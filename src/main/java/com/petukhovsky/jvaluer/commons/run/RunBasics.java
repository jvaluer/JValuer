package com.petukhovsky.jvaluer.commons.run;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    public String getIn() {
        return inOut.getIn();
    }

    @JsonIgnore
    public String getOut() {
        return inOut.getOut();
    }

    @JsonIgnore
    public Long getMemoryLimit() {
        return limits.getMemory();
    }

    @JsonIgnore
    public Long getTimeLimit() {
        return limits.getTime();
    }
}
