package com.petukhovsky.jvaluer.commons.api.response.progress;

import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;

/**
 * Created by Arthur Petukhovsky on 6/21/2016.
 */
public class Compiled extends Progress {
    private CompilationResult result;

    public Compiled(String tokenId, String submissionId, String act, CompilationResult result) {
        super(tokenId, submissionId, act);
        this.result = result;
    }

    public CompilationResult getResult() {
        return result;
    }

    public void setResult(CompilationResult result) {
        this.result = result;
    }
}
