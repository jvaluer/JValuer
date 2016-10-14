package com.petukhovsky.jvaluer.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class SourceInfo {
    private final String lang;
    private final String url;

    @JsonCreator
    public SourceInfo(@JsonProperty("lang") String lang, @JsonProperty("url") String url) {
        this.lang = lang;
        this.url = url;
    }

    public String getLang() {
        return lang;
    }

    public String getUrl() {
        return url;
    }
}
