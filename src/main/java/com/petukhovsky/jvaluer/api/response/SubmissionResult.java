package com.petukhovsky.jvaluer.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.test.result.TestingResult;

/**
 * Created by arthur on 26.10.16.
 */
public class SubmissionResult {
    private final TestingResult result;
    private final Error error;

    @JsonCreator
    public SubmissionResult(@JsonProperty("result") TestingResult result,
                            @JsonProperty("error") Error error) {
        this.result = result;
        this.error = error;
    }

    public TestingResult getResult() {
        return result;
    }

    public Error getError() {
        return error;
    }
}
