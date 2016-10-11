package com.petukhovsky.jvaluer.commons.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 11.10.16.
 */
public class TestVerdict {
    private final String verdict;
    private final boolean correct;

    @JsonCreator
    public TestVerdict(@JsonProperty("verdict") String verdict, @JsonProperty("correct") boolean correct) {
        this.verdict = verdict;
        this.correct = correct;
    }

    public String getVerdict() {
        return verdict;
    }

    public boolean isCorrect() {
        return correct;
    }
}
