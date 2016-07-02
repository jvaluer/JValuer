package com.petukhovsky.jvaluer.commons.run;

/**
 * Created by Arthur Petukhovsky on 7/3/2016.
 */
public class RunBasics {
    private final RunLimits limits;
    private final RunInOut inOut;

    public RunBasics(RunLimits limits, RunInOut inOut) {
        this.limits = limits;
        this.inOut = inOut;
    }

    public RunLimits getLimits() {
        return limits;
    }

    public RunInOut getInOut() {
        return inOut;
    }

    public String getIn() {
        return inOut.getIn();
    }

    public String getOut() {
        return inOut.getOut();
    }

    public Long getMemoryLimit() {
        return limits.getMemory();
    }

    public Long getTimeLimit() {
        return limits.getTime();
    }
}
