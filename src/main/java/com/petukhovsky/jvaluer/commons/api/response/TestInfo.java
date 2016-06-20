package com.petukhovsky.jvaluer.commons.api.response;

import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class TestInfo {
    private RunInfo run;
    private CheckResult check;
    private TestData out;

    public TestInfo(RunInfo run, CheckResult check, TestData out) {
        this.run = run;
        this.check = check;
        this.out = out;
    }

    public RunInfo getRun() {
        return run;
    }

    public void setRun(RunInfo run) {
        this.run = run;
    }

    public CheckResult getCheck() {
        return check;
    }

    public void setCheck(CheckResult check) {
        this.check = check;
    }

    public TestData getOut() {
        return out;
    }

    public void setOut(TestData out) {
        this.out = out;
    }
}
