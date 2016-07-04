package com.petukhovsky.jvaluer.commons.api.response;

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

    public TestInfo(RunInfo run, CheckResult check, TestData out) {
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
