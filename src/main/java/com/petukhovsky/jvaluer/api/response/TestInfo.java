package com.petukhovsky.jvaluer.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class TestInfo {
    private final RunInfo run;
    private final CheckResult check;
    private final TestData out;

    @JsonCreator
    public TestInfo(@JsonProperty("run") RunInfo run, @JsonProperty("check") CheckResult check, @JsonProperty("out") TestData out) {
        this.run = run;
        this.check = check;
        this.out = out;
    }

    public RunInfo getRun() {
        return run;
    }

    public CheckResult getCheck() {
        return check;
    }

    public TestData getOut() {
        return out;
    }
}
