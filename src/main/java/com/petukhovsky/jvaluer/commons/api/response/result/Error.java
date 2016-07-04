package com.petukhovsky.jvaluer.commons.api.response.result;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class Error {
    private final String message;
    private final Exception exception;

    public Error(String message, Exception exception) {
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
