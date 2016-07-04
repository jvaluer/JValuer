package com.petukhovsky.jvaluer.commons.run;

import com.petukhovsky.jvaluer.commons.data.PathData;

/**
 * Created by Arthur Petukhovsky on 7/4/2016.
 */
public class InvocationResult {
    private final RunInfo run;
    private final PathData out;

    public InvocationResult(RunInfo run, PathData out) {
        this.run = run;
        this.out = out;
    }

    public RunInfo getRun() {
        return run;
    }

    public PathData getOut() {
        return out;
    }
}
