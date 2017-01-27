package com.petukhovsky.jvaluer.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.lang.reflect.Field;

/**
 * Created by petuh on 22.11.2016.
 */
public class UnixUtils {
    private static CLibrary libc = null;

    private static CLibrary libc() {
        if (libc != null) return libc;
        return libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);
    }

    interface CLibrary extends Library {
        int chmod(String path, int mode);
    }

    public static int chmod(String path, int mode) {
        return libc().chmod(path, mode);
    }

    public static Integer getPid(Process process) {
        if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
            try {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                return f.getInt(process);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
