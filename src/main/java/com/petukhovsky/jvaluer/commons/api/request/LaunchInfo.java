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
    private final String queueId;
    private final String source;
    private final String sourceLang;

    @JsonCreator
    public LaunchInfo(@JsonProperty("input") String input,
                      @JsonProperty("basics") RunBasics basics,
                      @JsonProperty("queueId") String queueId,
                      @JsonProperty("source") String source,
                      @JsonProperty("sourceLang") String sourceLang) {
        this.input = input;
        this.basics = basics;
        this.queueId = queueId;
        this.source = source;
        this.sourceLang = sourceLang;
    }

    public String getInput() {
        return input;
    }

    public RunBasics getBasics() {
        return basics;
    }

    public String getQueueId() {
        return queueId;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public String getSource() {
        return source;
    }
}
