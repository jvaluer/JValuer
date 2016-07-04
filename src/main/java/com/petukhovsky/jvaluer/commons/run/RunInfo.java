package com.petukhovsky.jvaluer.commons.run;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur on 12/18/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunInfo {
    private final RunVerdict runVerdict;
    private final long exitCode;
    private final long userTime;
    private final long kernelTime;
    private final long passedTime;
    private final long consumedMemory;
    private final String comment;

    @JsonCreator
    public RunInfo(@JsonProperty("runVerdict") RunVerdict runVerdict,
                   @JsonProperty("exitCode") int exitCode,
                   @JsonProperty("userTime") long userTime,
                   @JsonProperty("kernelTime") long kernelTime,
                   @JsonProperty("passedTime") long passedTime,
                   @JsonProperty("consumedMemory") long consumedMemory,
                   @JsonProperty("comment") String comment) {
        this.runVerdict = runVerdict;
        this.exitCode = exitCode;
        this.userTime = userTime;
        this.kernelTime = kernelTime;
        this.passedTime = passedTime;
        this.consumedMemory = consumedMemory;
        this.comment = comment;
    }

    public static RunInfo crashed(String comment) {
        return new RunInfo(RunVerdict.CRASH, -1, -1, -1, -1, -1, comment);
    }

    public static RunInfo completed(RunVerdict runVerdict, int exitCode, int userTime, int kernelTime, int passedTime, int consumedMemory, String comment) {
        return new RunInfo((exitCode != 0 && runVerdict == RunVerdict.SUCCESS) ? RunVerdict.RUNTIME_ERROR : runVerdict,
                exitCode,
                userTime,
                kernelTime,
                passedTime,
                consumedMemory,
                comment);
    }

    public RunVerdict getRunVerdict() {
        return runVerdict;
    }

    public long getExitCode() {
        return exitCode;
    }

    public long getUserTime() {
        return userTime;
    }

    public long getKernelTime() {
        return kernelTime;
    }

    public long getPassedTime() {
        return passedTime;
    }

    public long getConsumedMemory() {
        return consumedMemory;
    }

    public String getComment() {
        return comment;
    }

    public String getTimeString() {
        return getUserTime() + " ms";
    }

    public String getMemoryString() {
        long memory = getConsumedMemory();
        double kb = memory / 1024D;
        double mb = kb / 1024D;
        if (mb < 2D) return String.format("%.2fkb", kb);
        return String.format("%.2fMB", mb);
    }

    @Override
    public String toString() {
        return runVerdict + " (" + this.getTimeString() + ", " + this.getMemoryString() + ") " + this.getComment() +
                (this.getExitCode() != 0 ? " [exitcode: " + this.getExitCode() + "]" : "");
    }
}
