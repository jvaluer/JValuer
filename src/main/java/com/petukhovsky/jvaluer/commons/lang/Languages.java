package com.petukhovsky.jvaluer.commons.lang;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by arthur on 14.10.16.
 */
public interface Languages {
    Language findByExtension(String ext);
    Language findByName(String name);
    Language findByPath(Path path);
    List<Language> getAll();
}
