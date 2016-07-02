package com.petukhovsky.jvaluer.commons.api.request;

import com.petukhovsky.jvaluer.commons.run.RunBasics;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class LaunchInfo {
    private final String inUrl;
    private final RunBasics basics;

    public LaunchInfo(String inUrl, RunBasics basics) {
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
