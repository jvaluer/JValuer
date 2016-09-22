package com.petukhovsky.jvaluer.commons.api.heartbeat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * Created by Arthur Petukhovsky on 6/11/2016.
 */
public class HeartbeatMessage {
    private final String tokenId;
    private final String version;
    private final Instant startTime;
    private final Instant now;

    @JsonCreator
    public HeartbeatMessage(@JsonProperty("startTime") Instant startTime, @JsonProperty("now") Instant now, @JsonProperty("version") String version, @JsonProperty("tokenId") String tokenId) {
        this.startTime = startTime;
        this.now = now;
        this.version = version;
        this.tokenId = tokenId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getNow() {
        return now;
    }

    public String getVersion() {
        return version;
    }

    public String getTokenId() {
        return tokenId;
    }
}
