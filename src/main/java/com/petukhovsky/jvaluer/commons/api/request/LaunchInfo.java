package com.petukhovsky.jvaluer.commons.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class LaunchInfo {
    private String inUrl;
    private long timeout;
    private String memoryLimit;

    public LaunchInfo() {
    }

    public LaunchInfo(String inUrl, long timeout, String memoryLimit) {
        this.inUrl = inUrl;
        this.timeout = timeout;
        this.memoryLimit = memoryLimit;
    }

    public String getInUrl() {
        return inUrl;
    }

    public void setInUrl(String inUrl) {
        this.inUrl = inUrl;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }
}
