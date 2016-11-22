package com.petukhovsky.jvaluer.util;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APIOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.Collections;
import java.util.EnumSet;

/**
 * Created by petuh on 22.11.2016.
 */
public class WindowsUtils {

    private static MyKernel32 myKernel32;

    public static MyKernel32 kernel32() {
        if (myKernel32 != null) return myKernel32;
        return myKernel32 = (MyKernel32) Native.loadLibrary("kernel32",
                MyKernel32.class, W32APIOptions.UNICODE_OPTIONS);
    }

    interface MyKernel32 extends WinNT {
        boolean RemoveDirectoryW(String lpPathName);
        boolean SetCurrentDirectoryW(String lpPathName);
    }

    public static boolean removeDirectory(Path path) {
        String stringPath = path.toAbsolutePath().toString();
        return kernel32().RemoveDirectoryW(stringPath);
    }

    public static boolean setCurrentDirectory(Path path) {
        String stringPath = path.toAbsolutePath().toString();
        return kernel32().SetCurrentDirectoryW(stringPath);
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
}
