package com.petukhovsky.jvaluer.commons.source;

/**
 * Created by arthur on 27.01.17.
 */
public class MemorySource {
    private final String source;
    private final String langId;

    public MemorySource(String source, String langId) {
        this.source = source;
        this.langId = langId;
    }

    public String getSource() {
        return source;
    }

    public String getLangId() {
        return langId;
    }
}
