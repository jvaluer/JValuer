package com.petukhovsky.jvaluer.util.string;

/**
 * Created by arthur on 21.10.16.
 */
public class ValueAndSuffix {
    private Long value;
    private String suffix;

    private ValueAndSuffix(Long value, String suffix) {
        this.value = value;
        this.suffix = suffix;
    }

    public Long getValue() {
        return value;
    }

    public String getSuffix() {
        return suffix;
    }

    public static ValueAndSuffix parse(String s) {
        if (s == null) return null;
        s = s.replaceAll(" ", "");
        int nnPos = 0;
        while (nnPos < s.length() && s.charAt(nnPos) >= '0' && s.charAt(nnPos) <= '9') nnPos++;
        String num = s.substring(0, nnPos);
        String suf = s.substring(nnPos);
        Long value;
        try {
            value = Long.parseLong(num);
        } catch (NumberFormatException e) {
            return null;
        }
        return new ValueAndSuffix(value, suf);
    }
}
