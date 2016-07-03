package com.petukhovsky.jvaluer.commons.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.run.RunBasics;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class LaunchInfo {
    private final String inUrl;
    private final RunBasics basics;

    @JsonCreator
    public LaunchInfo(@JsonProperty("inUrl") String inUrl, @JsonProperty("basics") RunBasics basics) {
        this.inUrl = inUrl;
        this.basics = basics;
    }

    public String getInUrl() {
        return inUrl;
    }

    public RunBasics getBasics() {
        return basics;
    }
}
