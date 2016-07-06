package com.petukhovsky.jvaluer.commons.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class Submission {
    private final String type;
    private final SourceInfo source;

    @JsonCreator
    public Submission(@JsonProperty("type") String type, @JsonProperty("source") SourceInfo source) {
        this.type = type;
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public SourceInfo getSource() {
        return source;
    }
}
