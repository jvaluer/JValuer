package com.petukhovsky.jvaluer.commons.run;

import com.petukhovsky.jvaluer.util.string.ValueAndSuffix;

/**
 * Created by Arthur Petukhovsky on 7/3/2016.
 */
public class RunLimits {
    private final Long time;
    private final Long memory;

    public RunLimits(Long time, Long memory) {
        if (time != null && time < 0) throw new IllegalArgumentException("Time can't be negative");
        if (memory != null && memory < 0) throw new IllegalArgumentException("Memory can't be negative");
        this.time = time;
        this.memory = memory;
    }

    public Long getTime() {
        return time;
    }

    public Long getMemory() {
        return memory;
    }

    public RunLimits withTime(Long time) {
        return new RunLimits(time, memory);
    }

    public RunLimits withTime(String time) {
        return new RunLimits(parseTime(time), memory);
    }

    public RunLimits withMemory(Long memory) {
        return new RunLimits(time, memory);
    }

    public RunLimits withMemory(String memory) {
        return new RunLimits(time, parseMemory(memory));
    }

    public static RunLimits ofMemory(Long memory) {
        return new RunLimits(null, memory);
    }

    public static RunLimits ofTime(Long time) {
        return new RunLimits(time, null);
    }

    public static RunLimits unlimited() {
        return new RunLimits(null, null);
    }

    public static RunLimits of(String time, String memory) {
        return new RunLimits(parseTime(time), parseMemory(memory));
    }

    public static String timeString(Long time) {
        if (time == null) return "";
        return time + " ms";
    }

    public static String memoryString(Long memory) {
        if (memory == null) return "";
        double kb = memory / 1024D;
        double mb = kb / 1024D;
        if (mb < 1D) return String.format("%.2f KB", kb);
        return String.format("%.2f MiB", mb);
    }

    public static Long parseTime(String time) {
        if (time == null || time.isEmpty()) return null;
        ValueAndSuffix vas = ValueAndSuffix.parse(time);
        if (vas == null) throw new IllegalArgumentException("bad format");
        switch (vas.getSuffix().toLowerCase()) {
            case "ms":
                return vas.getValue();
            case "s":
                return vas.getValue() * 1000L;
            case "":
                return vas.getValue();
            case "m":
                return vas.getValue() * 1000L * 60L;
            default:
                throw new IllegalArgumentException("unknown time suffix");
        }
    }

    public static Long parseMemory(String memory) {
        if (memory == null || memory.isEmpty()) return null;
        ValueAndSuffix vas = ValueAndSuffix.parse(memory);
        if (vas == null) throw new IllegalArgumentException("bad format");
        switch (vas.getSuffix().toLowerCase()) {
            case "b":
                return vas.getValue();
            case "kb":
                return vas.getValue() * 1024L;
            case "k":
                return vas.getValue() * 1024L;
            case "":
                return vas.getValue();
            case "m":
                return vas.getValue() * 1024L * 1024L;
            case "mb":
                return vas.getValue() * 1024L * 1024L;
            case "mib":
                return vas.getValue() * 1024L * 1024L;
            default:
                throw new IllegalArgumentException("unknown memory suffix");
        }
    }
}
