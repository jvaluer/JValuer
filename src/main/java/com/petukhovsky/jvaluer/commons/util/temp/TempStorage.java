package com.petukhovsky.jvaluer.commons.util.temp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Arthur Petukhovsky on 7/2/2016.
 */
public class TempStorage {

    private static final Logger log = Logger.getLogger(TempStorage.class.getName());

    private static final int BUFFER = 2048;

    private final Path path;

    public TempStorage(Path path) throws IOException {
        this.path = path;
        Files.createDirectories(path);
    }

    private TempDirectory create(String name) throws IOException {
        return new TempDirectory(path.resolve(name));
    }

    public TempDirectory createTempDirectory() {
        try {
            return new TempDirectory(Files.createTempDirectory(path, ""));
        } catch (IOException e) {
            log.log(Level.WARNING, "can't create temp directory", e);
        }
        return null;
    }

    public TempDirectory unzip(InputStream inputStream) {
        TempDirectory tempDirectory = createTempDirectory();
        try (ZipInputStream zis = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    zis.closeEntry();
                    continue;
                }
                Path file = tempDirectory.resolve(entry.getName());
                Files.copy(zis, file, REPLACE_EXISTING);
                zis.closeEntry();
            }
        } catch (IOException e) {
            log.log(Level.WARNING, "can't unzip to temp directory", e);
        }
        return tempDirectory;
    }
}
