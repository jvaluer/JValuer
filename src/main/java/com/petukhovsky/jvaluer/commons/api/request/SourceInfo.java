package com.petukhovsky.jvaluer.commons.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class SourceInfo {
    private final String lang;
    private final String url;

    public SourceInfo(String lang, String url) {
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
