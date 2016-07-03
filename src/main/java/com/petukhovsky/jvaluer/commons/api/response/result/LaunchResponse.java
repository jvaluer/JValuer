package com.petukhovsky.jvaluer.commons.api.response.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class LaunchResponse extends Response {
    private final RunInfo run;
    private final String out;
    private final CompilationResult compile;

    @JsonCreator
    public LaunchResponse(@JsonProperty("run") RunInfo run, @JsonProperty("out") String out, @JsonProperty("compile") CompilationResult compile) {
        this.run = run;
        this.out = out;
        this.compile = compile;
    }

    public CompilationResult getCompile() {
        return compile;
    }

    public RunInfo getRun() {
        return run;
    }

    public String getOut() {
        return out;
    }
}
