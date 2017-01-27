package com.petukhovsky.jvaluer.commons.run;

import com.petukhovsky.jvaluer.commons.msg.Verdict;
import com.petukhovsky.jvaluer.commons.msg.VerdictLabel;

/**
 * Created by Arthur on 12/18/2015.
 */
public class RunInfo {
    private final Verdict verdict;
    private final long exitCode;
    private final long userTime;
    private final long kernelTime;
    private final long passedTime;
    private final long consumedMemory;

    public RunInfo(Verdict verdict,
                   long exitCode,
                   long userTime,
                   long kernelTime,
                   long passedTime,
                   long consumedMemory
    ) {
        this.verdict = verdict;
        this.exitCode = exitCode;
        this.userTime = userTime;
        this.kernelTime = kernelTime;
        this.passedTime = passedTime;
        this.consumedMemory = consumedMemory;
    }

    public static RunInfo crashed(String comment) {
        return new RunInfo(new Verdict(VerdictLabel.CRASHED, comment), -1, -1, -1, -1, -1);
    }

    public static RunInfo completed(Verdict verdict, long exitCode, long userTime, long kernelTime, long passedTime, long consumedMemory) {
        return new RunInfo(
                verdict,
                exitCode,
                userTime,
                kernelTime,
                passedTime,
                consumedMemory
        );
    }

    public Verdict getVerdict() {
        return verdict;
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
        return verdict.getComment();
    }

    public String getTimeString() {
        return RunLimits.timeString(userTime);
    }

    public String getMemoryString() {
        return RunLimits.memoryString(consumedMemory);
    }

    @Override
    public String toString() {
        return verdict + " (" + this.getTimeString() + ", " + this.getMemoryString() + ") " + this.getComment() +
                (this.getExitCode() != 0 ? " [exitcode: " + this.getExitCode() + "]" : "");
    }
}
