package com.petukhovsky.jvaluer.commons.local;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by arthur on 19.12.16.
 */
public class ResourcesImpl implements Resources {

    private static Logger logger = Logger.getLogger(ResourcesImpl.class.getName());

    private final Path store;

    public ResourcesImpl(Path store) {
        this.store = store;
    }

    @Override
    public Path getResource(String name) {
        Path file = store.resolve(name);
        if (Files.exists(file)) return file;
        return Local.loadResource("/" + name, file);
    }
}
