package com.petukhovsky.jvaluer.commons.util.temp;

import org.apache.commons.io.FileUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur Petukhovsky on 7/2/2016.
 */
public class TempDirectory implements Closeable, AutoCloseable {

    private static final Logger log = Logger.getLogger(TempDirectory.class.getName());

    private final Path root;

    TempDirectory(Path root) throws IOException {
        this.root = root;
        Files.createDirectories(root);
    }

    public Path getRoot() {
        return root;
    }

    public Path resolve(String suffix) {
        System.err.println("try to resolve " + suffix);
        Path path = root.resolve(suffix).toAbsolutePath();
        System.err.println("resolved path: " + path);
        Path parent = path.getParent();
        System.err.println("parent is " + parent);
        try {
            Files.createDirectories(parent);
        } catch (IOException e) {
            log.log(Level.WARNING, "resolve suffix in TempDirectory", e);
        }
        return path;
    }

    public OutputStream openOutputStream(String suffix) throws IOException {
        return Files.newOutputStream(resolve(suffix));
    }

    @Override
    public void close() throws IOException {
        FileUtils.deleteDirectory(root.toFile());
    }
}
