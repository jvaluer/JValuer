package com.petukhovsky.jvaluer.commons.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class LaunchResponse {
    private final RunInfo run;
    private final TruncatedOut out;
    private final CompilationResult compile;
    private final Error error;

    @JsonCreator
    public LaunchResponse(@JsonProperty("run") RunInfo run, @JsonProperty("out") TruncatedOut out, @JsonProperty("compile") CompilationResult compile) {
        this.run = run;
        this.out = out;
        this.compile = compile;
        this.error = null;
    }

    @JsonCreator
    public LaunchResponse(@JsonProperty("error") Error error) {
        this.error = error;
        this.run = null;
        this.out = null;
        this.compile = null;
    }

    public CompilationResult getCompile() {
        return compile;
    }

    public RunInfo getRun() {
        return run;
    }

    public TruncatedOut getOut() {
        return out;
    }
}
