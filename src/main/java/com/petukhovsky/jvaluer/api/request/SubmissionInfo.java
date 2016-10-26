package com.petukhovsky.jvaluer.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 26.10.16.
 */
public class SubmissionInfo {
    private final UrlResource pkg;

    private final String source;
    private final String sourceLang;

    private final String resultUrl;
    private final String compileUrl;
    private final String testUrl;

    @JsonCreator
    public SubmissionInfo(@JsonProperty("pkg") UrlResource pkg,
                          @JsonProperty("source") String source,
                          @JsonProperty("sourceLang") String sourceLang,
                          @JsonProperty("resultUrl") String resultUrl,
                          @JsonProperty("compileUrl") String compileUrl,
                          @JsonProperty("testUrl") String testUrl) {
        this.pkg = pkg;
        this.source = source;
        this.sourceLang = sourceLang;
        this.resultUrl = resultUrl;
        this.compileUrl = compileUrl;
        this.testUrl = testUrl;
    }

    public UrlResource getPkg() {
        return pkg;
    }

    public String getSource() {
        return source;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public String getCompileUrl() {
        return compileUrl;
    }

    public String getTestUrl() {
        return testUrl;
    }
}
