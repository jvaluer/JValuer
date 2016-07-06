package com.petukhovsky.jvaluer.commons.api.response.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class Error {
    private final String message;
    private final Exception exception;

    @JsonCreator
    public Error(@JsonProperty("message") String message, @JsonProperty("exception") Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
