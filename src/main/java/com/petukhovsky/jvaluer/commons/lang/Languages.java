package com.petukhovsky.jvaluer.commons.lang;

import com.petukhovsky.jvaluer.commons.source.LocalSource;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by arthur on 14.10.16.
 */
public interface Languages {
    Language findByExtension(String ext);
    Language findByName(String name);
    Language findByPath(Path path);
    LocalSource autoSource(Path source);
    List<Language> getAll();
}
