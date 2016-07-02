package com.petukhovsky.jvaluer.commons.api.response.result;

import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class LaunchResponse extends Response {
    private RunInfo run;
    private String out;
    private CompilationResult compile;

    public LaunchResponse(RunInfo run, String out, CompilationResult compile) {
        this.run = run;
        this.out = out;
        this.compile = compile;
    }

    public CompilationResult getCompile() {
        return compile;
    }

    public void setCompile(CompilationResult compile) {
        this.compile = compile;
    }

    public RunInfo getRun() {
        return run;
    }

    public void setRun(RunInfo run) {
        this.run = run;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
