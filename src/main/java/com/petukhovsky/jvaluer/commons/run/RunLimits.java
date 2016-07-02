package com.petukhovsky.jvaluer.commons.run;

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

    public static RunLimits ofMemory(Long memory) {
        return new RunLimits(null, memory);
    }

    public static RunLimits ofTime(Long time) {
        return new RunLimits(time, null);
    }

    public static RunLimits unlimited() {
        return new RunLimits(null, null);
    }

    public Long getMemory() {
        return memory;
    }

    public Long getTime() {
        return time;
    }
}
