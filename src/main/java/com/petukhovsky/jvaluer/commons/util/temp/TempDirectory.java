package com.petukhovsky.jvaluer.commons.util.temp;

import com.petukhovsky.jvaluer.commons.util.FilesUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Arthur Petukhovsky on 7/2/2016.
 */
public class TempDirectory implements Closeable, AutoCloseable {
    private final Path root;

    TempDirectory(Path root) throws IOException {
        this.root = root;
        Files.createDirectories(root);
    }

    public Path getRoot() {
        return root;
    }

    public Path resolve(String suffix) throws IOException {
        Path path = root.resolve(suffix);
        Files.createDirectories(path);
        return path;
    }

    public OutputStream openOutputStream(String suffix) throws IOException {
        return Files.newOutputStream(resolve(suffix));
    }

    @Override
    public void close() throws IOException {
        FilesUtils.deleteDirectory(root);
    }
}
