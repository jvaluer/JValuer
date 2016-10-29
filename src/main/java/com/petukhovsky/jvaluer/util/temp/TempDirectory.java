package com.petukhovsky.jvaluer.util.temp;

import com.petukhovsky.jvaluer.commons.local.Local;
import com.petukhovsky.jvaluer.util.FilesUtils;
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
        FilesUtils.chmod(root, 777);
    }

    public Path getRoot() {
        return root;
    }

    public Path resolve(String suffix) {
        Path path = getRoot();
        path = path.resolve(suffix);
        path = path.toAbsolutePath();
        path = path.getParent();
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            log.log(Level.WARNING, "resolve suffix in TempDirectory", e);
        }
        return getRoot().resolve(suffix);
    }

    public OutputStream openOutputStream(String suffix) throws IOException {
        return Files.newOutputStream(resolve(suffix));
    }

    @Override
    public void close() throws IOException {
        FileUtils.deleteDirectory(root.toFile());
    }

    public Path resolveQuiet(String name) {
        return root.resolve(name);
    }
}
