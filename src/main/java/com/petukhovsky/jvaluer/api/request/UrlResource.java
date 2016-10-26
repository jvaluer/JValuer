package com.petukhovsky.jvaluer.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class UrlResource {
    private final String uid;
    private final String url;

    @JsonCreator
    public UrlResource(@JsonProperty("uid") String uid,
                       @JsonProperty("url") String url) {
        this.url = url;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public String getUrl() {
        return url;
    }
}
