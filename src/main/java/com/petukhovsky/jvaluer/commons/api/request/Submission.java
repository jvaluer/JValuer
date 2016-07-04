package com.petukhovsky.jvaluer.commons.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class Submission {
    private final String type;
    private final SourceInfo source;

    public Submission(String type, SourceInfo source) {
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
