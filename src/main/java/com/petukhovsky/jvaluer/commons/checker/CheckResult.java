package com.petukhovsky.jvaluer.commons.checker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur on 12/19/2015.
 */
public class CheckResult {
    private final boolean correct;
    private final double result;
    private final String comment;

    public CheckResult(boolean correct, String comment) {
        this(correct, correct ? 1D : 0D, comment);
    }

    public CheckResult(double result, String comment) {
        this.result = result;
        this.comment = comment;
        this.correct = result >= 1D;
    }

    @JsonCreator
    public CheckResult(@JsonProperty("correct") boolean correct, @JsonProperty("result") double result, @JsonProperty("comment") String comment) {
        this.correct = correct;
        this.result = result;
        this.comment = comment;
    }

    public boolean isCorrect() {
        return correct;
    }

    public double getResult() {
        return result;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return (isCorrect() ? "ok" : "wa") + " : " + comment;
    }
}
