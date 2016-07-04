package com.petukhovsky.jvaluer.commons.data;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur on 12/21/2015.
 */
public class PathData extends TestData {

    private final static Logger log = Logger.getLogger(PathData.class.getName());

    private final Path path;

    public PathData(Path path) {
        this.path = path;
    }

    @Override
    public boolean exists() {
        return path != null && Files.exists(path);
    }

    @Override
    public InputStream openInputStream() {
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            log.log(Level.WARNING, "can't open input stream", e);
        }
        return null;
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public String getString() {
        try {
            return new String(Files.readAllBytes(path), "UTF-8");
        } catch (IOException e) {
            log.log(Level.WARNING, "can't read file", e);
        }
        return null;
    }
}
