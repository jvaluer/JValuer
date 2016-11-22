package com.petukhovsky.jvaluer.util;

import com.petukhovsky.jvaluer.commons.local.OS;
import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by petuh on 22.11.2016.
 */
public class UnixUtils {
    private static CLibrary libc = null;

    public static CLibrary libc() {
        if (libc != null) return libc;
        return  libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);
    }

    interface CLibrary extends Library {
        public int chmod(String path, int mode);
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
