package com.petukhovsky.jvaluer.commons.run;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 7/3/2016.
 */
public class RunInOut {
    private final String in;
    private final String out;

    @JsonCreator
    public RunInOut(@JsonProperty("in") String in, @JsonProperty("out") String out) {
        if (in == null) throw new IllegalArgumentException("In can't be null");
        if (out == null) throw new IllegalArgumentException("Out can't be null");
        if (in.isEmpty()) throw new IllegalArgumentException("In file can't be empty");
        if (out.isEmpty()) throw new IllegalArgumentException("Out file can't be empty");
        this.in = in;
        this.out = out;
    }

    public static RunInOut std() {
        return new RunInOut("stdin", "stdout");
    }

    public static RunInOut txt() {
        return new RunInOut("input.txt", "output.txt");
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
}
