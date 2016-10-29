package com.petukhovsky.jvaluer.util;

import com.petukhovsky.jvaluer.commons.local.OS;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.*;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur Petukhovsky on 7/4/2016.
 */
public class FilesUtils {

    private final static Logger log = Logger.getLogger(FilesUtils.class.getName());
    private static CLibrary libc = null;

    private static CLibrary libc() {
        if (libc != null) return libc;
        return  libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);
    }

    public static boolean removeRecursiveForce(Path path) {
        for (int i = 0; i < 20; i++) {
            if (Files.notExists(path)) return true;
            myTryDelete(path);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        log.log(Level.SEVERE, "can't delete THAT -> (" + path.toAbsolutePath().toString() + ")");
        return Files.notExists(path);
    }

    public static boolean assureEmptyDir(Path path) {
        if (Files.exists(path) && Files.isDirectory(path)) {
            return cleanDirectory(path);
        }
        removeRecursiveForce(path);
        if (!Files.exists(path) && forceCreateDirs(path)) {
            return true;
        }
        log.log(Level.SEVERE, "can't make THAT -> (" + path.toAbsolutePath().toString() + ") directory empty");
        return false;
    }

    public static void chmod(Path path, int mode) {
        if (path == null) return;
        path = path.toAbsolutePath();
        if (OS.isWindows()) chmodJava(path, mode);
        libc().chmod(path.toString(), mode);
    }

    private static void chmodJava(Path path, int mode) {
        String s = "0000" + mode;
        s = s.substring(s.length() - 3);
        RWX owner = new RWX(s.charAt(0) - '0');
        RWX other = new RWX(s.charAt(1) - '0').apply(new RWX(s.charAt(2) - '0'));
        owner = owner.apply(other);
        File file = path.toFile();
        file.setReadable(owner.isRead(), owner.isRead() != other.isRead());
        file.setWritable(owner.isWrite(), owner.isWrite() != other.isWrite());
        file.setExecutable(owner.isExecute(), owner.isExecute() != other.isExecute());
    }

    @Deprecated
    private static void chmod777Windows(Path executable) throws IOException {
        AclFileAttributeView aclAttr = Files.getFileAttributeView(executable, AclFileAttributeView.class);

        UserPrincipalLookupService upls = executable.getFileSystem().getUserPrincipalLookupService();
        UserPrincipal user = upls.lookupPrincipalByName(System.getProperty("user.name"));
        AclEntry.Builder builder = AclEntry.newBuilder();
        builder.setPermissions(EnumSet.of(AclEntryPermission.READ_DATA, AclEntryPermission.EXECUTE,
                AclEntryPermission.READ_ACL, AclEntryPermission.READ_ATTRIBUTES, AclEntryPermission.READ_NAMED_ATTRS,
                AclEntryPermission.WRITE_ACL, AclEntryPermission.DELETE
        ));
        builder.setPrincipal(user);
        builder.setType(AclEntryType.ALLOW);
        aclAttr.setAcl(Collections.singletonList(builder.build()));
    }

    @Deprecated
    private static void chmod777Unix(Path executable) throws IOException {
        Set<PosixFilePermission> perms = new HashSet<>();
        //add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        //add group permissions
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        //add others permissions
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Files.setPosixFilePermissions(executable, perms);
    }

    private static void delete(Path path) {
        if (Files.isDirectory(path)) {
            cleanDirectoryOld(path);
            try {
                Files.list(path).forEach(FilesUtils::delete);
            } catch (IOException e) {
                //log.log(Level.WARNING, "", e);
            }
        }
        if (Files.exists(path)) {
            try {
                FileDeleteStrategy.FORCE.delete(path.toFile());
            } catch (IOException e) {
                //log.log(Level.WARNING, "", e);
            }
        }
    }

    private static void cleanDirectoryOld(Path path) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!dir.equals(path)) Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            //log.log(Level.WARNING, "can't clean directory", e);
        }
    }

    private static void myTryDelete(Path path) {
        try {
            FileUtils.forceDelete(path.toFile());
        } catch (IOException e) {
        }
        FileUtils.deleteQuietly(path.toFile());
        delete(path);
    }

    private static boolean cleanDirectory(Path path) {
        final boolean[] ok = {true};
        try {
            Files.list(path).forEach(child -> ok[0] &= removeRecursiveForce(child));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok[0];
    }

    private static boolean forceCreateDirs(Path path) {
        try {
            Files.createDirectories(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Works too well, but also kill current java program as side effect
     * @param path path to file
     */
    private static void killProcessesByPath(Path path) {
        if (!OS.isUnix()) return;
        String cmd = String.format("lsof | grep %s | awk '{print $2}' | xargs kill -9", path.toAbsolutePath().toString());
        try {
            Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", cmd}).waitFor();
        } catch (InterruptedException | IOException e) {
            //e.printStackTrace();
        }
    }
}

interface CLibrary extends Library {
    public int chmod(String path, int mode);
}

class RWX {

    private final boolean read;
    private final boolean write;
    private final boolean execute;

    RWX(int mode) {
        execute = mode % 2 == 1;
        write = mode % 2 > 1;
        read = mode > 3;
    }

    RWX(boolean read, boolean write, boolean execute) {
        this.read = read;
        this.write = write;
        this.execute = execute;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isWrite() {
        return write;
    }

    public boolean isExecute() {
        return execute;
    }

    public RWX apply(RWX to) {
        return new RWX(to.read | read, to.write | write, to.execute | execute);
    }
}