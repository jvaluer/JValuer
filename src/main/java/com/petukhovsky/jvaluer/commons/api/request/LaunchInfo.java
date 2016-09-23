package com.petukhovsky.jvaluer.commons.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.run.RunBasics;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class LaunchInfo {
    private final String input;
    private final RunBasics basics;
    private final String source;
    private final String sourceLang;
    private final String completeUrl;

    @JsonCreator
    public LaunchInfo(@JsonProperty("input") String input,
                      @JsonProperty("basics") RunBasics basics,
                      @JsonProperty("source") String source,
                      @JsonProperty("sourceLang") String sourceLang,
                      @JsonProperty("completeUrl") String completeUrl) {
        this.input = input;
        this.basics = basics;
        this.source = source;
        this.sourceLang = sourceLang;
        this.completeUrl = completeUrl;
    }

    public String getInput() {
        return input;
    }

    public RunBasics getBasics() {
        return basics;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public String getSource() {
        return source;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }
}
