package com.petukhovsky.jvaluer.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.data.TruncatedOut;
import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.jvaluer.commons.test.TestVerdict;

/**
 * Created by arthur on 26.10.16.
 */
public class SubmissionTest {
    private final int test;

    private final String in;
    private final String out;
    private final String answer;

    private final RunInfo run;
    private final CheckResult check;
    private final TestVerdict verdict;

    @JsonCreator
    public SubmissionTest(@JsonProperty("test") int test,
                          @JsonProperty("in") String in,
                          @JsonProperty("out") String out,
                          @JsonProperty("answer") String answer,
                          @JsonProperty("run") RunInfo run,
                          @JsonProperty("check") CheckResult check,
                          @JsonProperty("verdict") TestVerdict verdict) {
        this.test = test;
        this.in = in;
        this.out = out;
        this.answer = answer;
        this.run = run;
        this.check = check;
        this.verdict = verdict;
    }

    public int getTest() {
        return test;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getAnswer() {
        return answer;
    }

    public RunInfo getRun() {
        return run;
    }

    public CheckResult getCheck() {
        return check;
    }

    public TestVerdict getVerdict() {
        return verdict;
    }
}
