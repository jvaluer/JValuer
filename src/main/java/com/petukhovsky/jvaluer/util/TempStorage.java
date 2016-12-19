package com.petukhovsky.jvaluer.util;

import com.petukhovsky.jvaluer.commons.local.OSValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur Petukhovsky on 7/2/2016.
 */
public class TempStorage {

    private static final Logger logger = Logger.getLogger(TempStorage.class.getName());

    private final Path path;

    public TempStorage(Path path) throws IOException {
        this.path = path;
        FilesUtils.assureEmptyDir(path);
    }

    public void cleanTemp() {
        FilesUtils.assureEmptyDir(path);
    }

    public Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) {
        try {
            return Files.createTempFile(path, prefix, suffix, attrs);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "can't create temp file", e);
        }
        return null;
    }

    public Path createTempExe() {
        Path exe = createTempFile("runnable", new OSValue<String>().windows(".exe").orElse(".out"));
        FilesUtils.chmod(exe, 777);
        return exe;
    }

    public Path createTempDir() {
        try {
            return Files.createTempDirectory(path, "dir");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "can't create temp directory", e);
        }
        return null;
    }
}
