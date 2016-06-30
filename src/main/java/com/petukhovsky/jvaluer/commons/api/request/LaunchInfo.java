package com.petukhovsky.jvaluer.commons.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class LaunchInfo {
    private String inUrl;

    public LaunchInfo() {
    }

    public LaunchInfo(String inUrl) {
        this.inUrl = inUrl;
    }

    public String getInUrl() {
        return inUrl;
    }

    public void setInUrl(String inUrl) {
        this.inUrl = inUrl;
    }
}
