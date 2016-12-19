package com.petukhovsky.jvaluer.util;

import com.petukhovsky.jvaluer.commons.local.OS;
import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.IOException;
import java.lang.reflect.Field;
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

    private static CLibrary libc() {
        if (libc != null) return libc;
        return  libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);
    }

    interface CLibrary extends Library {
        int chmod(String path, int mode);
    }

    public static int chmod(String path, int mode) {
        return libc().chmod(path, mode);
    }

    public static String getPid(Process process) {
        if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
            try {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                return "" + f.getInt(process);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
