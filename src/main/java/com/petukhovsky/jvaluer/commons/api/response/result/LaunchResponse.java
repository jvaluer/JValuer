package com.petukhovsky.jvaluer.commons.api.response.result;

import com.petukhovsky.jvaluer.commons.api.response.TestInfo;
import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;

/**
 * Created by Arthur Petukhovsky on 6/20/2016.
 */
public class LaunchResponse extends Response {
    private TestInfo test;
    private CompilationResult compile;

    public LaunchResponse(TestInfo testInfo, CompilationResult compile) {
        this.test = testInfo;
        this.compile = compile;
    }

    public TestInfo getTest() {
        return test;
    }

    public void setTest(TestInfo test) {
        this.test = test;
    }

    public CompilationResult getCompile() {
        return compile;
    }

    public void setCompile(CompilationResult compile) {
        this.compile = compile;
    }
}
