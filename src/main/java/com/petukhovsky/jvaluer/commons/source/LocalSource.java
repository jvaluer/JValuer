package com.petukhovsky.jvaluer.commons.source;

import com.petukhovsky.jvaluer.commons.lang.Language;

import java.nio.file.Path;

/**
 * Created by arthur on 14.10.16.
 */
public class LocalSource {
    private final Path path;
    private final Language language;

    public LocalSource(Path path, Language language) {
        this.path = path;
        this.language = language;
    }

    public Path getPath() {
        return path;
    }

    public Language getLanguage() {
        return language;
    }
}
