package com.petukhovsky.jvaluer.commons.run;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 7/3/2016.
 */
public class RunBasics {
    private final RunLimits limits;
    private final RunInOut inOut;

    @JsonCreator
    public RunBasics(@JsonProperty("limits") RunLimits limits, @JsonProperty("inOut") RunInOut inOut) {
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
