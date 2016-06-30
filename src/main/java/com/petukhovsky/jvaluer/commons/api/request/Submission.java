package com.petukhovsky.jvaluer.commons.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class Submission {
    private String type;
    private SourceInfo source;

    public Submission() {
    }

    public Submission(String type, SourceInfo source) {
        this.type = type;
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SourceInfo getSource() {
        return source;
    }

    public void setSource(SourceInfo source) {
        this.source = source;
    }
}
