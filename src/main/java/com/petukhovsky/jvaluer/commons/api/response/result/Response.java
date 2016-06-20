package com.petukhovsky.jvaluer.commons.api.response.result;

/**
 * Created by Arthur Petukhovsky on 6/21/2016.
 */
public class Response {
    private Error error;

    public Response(Error error) {
        this.error = error;
    }

    public Response() {
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
