package com.petukhovsky.jvaluer.util.res;

import com.petukhovsky.jvaluer.commons.data.PathData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by arthur on 16.10.16.
 */
public class PathResourceReader implements ResourceReader {

    private final Path path;

    public PathResourceReader(Path path) {
        this.path = path;
    }

    @Override
    public String readString(String path) {
        if (!exists(path)) return null;
        return new PathData(getPath(path)).getString();
    }

    @Override
    public InputStream openInputStream(String path) {
        if (!exists(path)) return null;
        try {
            return Files.newInputStream(getPath(path));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean exists(String path) {
        return Files.exists(getPath(path));
    }

    private Path getPath(String path) {
        return this.path.resolve(path);
    }
}
