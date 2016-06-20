package com.petukhovsky.jvaluer.commons.api.heartbeat;

import java.time.Instant;

/**
 * Created by Arthur Petukhovsky on 6/11/2016.
 */
public class HeartbeatMessage {
    private String tokenId;
    private String version;
    private Instant startTime;
    private Instant now;

    public HeartbeatMessage() {
    }

    public HeartbeatMessage(Instant startTime, Instant now, String version, String tokenId) {
        this.startTime = startTime;
        this.now = now;
        this.version = version;
        this.tokenId = tokenId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getNow() {
        return now;
    }

    public void setNow(Instant now) {
        this.now = now;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
