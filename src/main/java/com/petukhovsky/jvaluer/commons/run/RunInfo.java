package com.petukhovsky.jvaluer.commons.run;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur on 12/18/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunInfo {
    private RunVerdict runVerdict;
    private int exitCode;
    private int userTime;
    private int kernelTime;
    private int passedTime;
    private int consumedMemory;
    private String comment;

    private RunInfo() {
    }

    @JsonCreator
    public static RunInfo jsonDeserialize(@JsonProperty("runVerdict") RunVerdict runVerdict,
                                          @JsonProperty("exitCode") int exitCode,
                                          @JsonProperty("userTime") int userTime,
                                          @JsonProperty("kernelTime") int kernelTime,
                                          @JsonProperty("passedTime") int passedTime,
                                          @JsonProperty("consumedMemory") int consumedMemory,
                                          @JsonProperty("comment") String comment) {
        RunInfo runInfo = new RunInfo();
        runInfo.runVerdict = runVerdict;
        runInfo.exitCode = exitCode;
        runInfo.userTime = userTime;
        runInfo.kernelTime = kernelTime;
        runInfo.passedTime = passedTime;
        runInfo.consumedMemory = consumedMemory;
        runInfo.comment = comment;
        return runInfo;
    }

    public static RunInfo crashed(String comment) {
        RunInfo info = new RunInfo();
        info.runVerdict = RunVerdict.CRASH;
        info.comment = comment;
        return info;
    }

    public static RunInfo completed(RunVerdict runVerdict, int exitCode, int userTime, int kernelTime, int passedTime, int consumedMemory, String comment) {
        RunInfo info = new RunInfo();
        info.runVerdict = runVerdict;
        info.exitCode = exitCode;
        if (exitCode != 0 && info.runVerdict == RunVerdict.SUCCESS) info.runVerdict = RunVerdict.RUNTIME_ERROR;
        info.userTime = userTime;
        info.kernelTime = kernelTime;
        info.passedTime = passedTime;
        info.consumedMemory = consumedMemory;
        info.comment = comment;
        return info;
    }

    public RunVerdict getRunVerdict() {
        return runVerdict;
    }

    public int getExitCode() {
        return exitCode;
    }

    public int getUserTime() {
        return userTime;
    }

    public int getKernelTime() {
        return kernelTime;
    }

    public int getPassedTime() {
        return passedTime;
    }

    public int getConsumedMemory() {
        return consumedMemory;
    }

    public String getComment() {
        return comment;
    }

    public String getTimeString() {
        return getUserTime() + " ms";
    }

    public String getMemoryString() {
        int memory = getConsumedMemory();
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
