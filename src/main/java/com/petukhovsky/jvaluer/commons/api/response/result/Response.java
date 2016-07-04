package com.petukhovsky.jvaluer.commons.api.response.result;

/**
 * Created by Arthur Petukhovsky on 6/21/2016.
 */
public class Response {
    private final Error error;

    public Response(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
