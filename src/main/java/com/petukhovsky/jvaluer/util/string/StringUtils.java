package com.petukhovsky.jvaluer.util.string;

/**
 * Created by arthur on 14.10.16.
 */
public class StringUtils {
    public static String truncate(String s, int len) {
        if (s.length() > len + 3) return s.substring(0, len) + "...";
        return s;
    }
}
