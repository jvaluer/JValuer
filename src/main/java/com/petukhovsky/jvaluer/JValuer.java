package com.petukhovsky.jvaluer;

import com.petukhovsky.jvaluer.commons.lang.Languages;

import java.nio.file.Path;

/**
 * Created by arthur on 14.10.16.
 */
public interface JValuer {
    Path loadResource(String name, String resource);
    Languages getLanguages();
}
