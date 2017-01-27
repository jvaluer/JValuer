package com.petukhovsky.jvaluer.util;

import java.util.Arrays;

/**
 * Created by arthur on 27.01.17.
 */
public class ArrayUtils {
    public static <T> T[] concat(T[] a, T[] b) {
        T[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static <T> T[] appendOne(T[] a, T b) {
        T[] result = Arrays.copyOf(a, a.length + 1);
        result[a.length] = b;
        return result;
    }
}
