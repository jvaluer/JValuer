package com.petukhovsky.jvaluer.commons.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 21.9.16.
 */
public class TruncatedOut {
    private final String out;
    private final long originalSize;
    private final long truncatedSize;

    @JsonCreator
    public TruncatedOut(@JsonProperty("out") String out, @JsonProperty("originalSize") long originalSize, @JsonProperty("truncatedSize") long truncatedSize) {
        this.out = out;
        this.originalSize = originalSize;
        this.truncatedSize = truncatedSize;
    }

    public long getOriginalSize() {
        return originalSize;
    }

    public long getTruncatedSize() {
        return truncatedSize;
    }

    public String getOut() {
        return out;
    }
}
