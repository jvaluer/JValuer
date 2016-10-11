package com.petukhovsky.jvaluer.commons.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.api.response.TruncatedOut;
import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by arthur on 8.10.16.
 */
public class TestResult {
    private final int test;
    private final RunInfo run;
    private final TruncatedOut out;
    private final CheckResult check;
    private final TestVerdict verdict;

    @JsonCreator
    public TestResult(@JsonProperty("test") int test,
                      @JsonProperty("run") RunInfo run,
                      @JsonProperty("out") TruncatedOut out,
                      @JsonProperty("check") CheckResult check,
                      @JsonProperty("verdict") TestVerdict verdict) {
        this.test = test;
        this.run = run;
        this.out = out;
        this.check = check;
        this.verdict = verdict;
    }

    public int getTest() {
        return test;
    }

    public RunInfo getRun() {
        return run;
    }

    public TruncatedOut getOut() {
        return out;
    }

    public CheckResult getCheck() {
        return check;
    }

    public TestVerdict getVerdict() {
        return verdict;
    }
}
