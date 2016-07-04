package com.petukhovsky.jvaluer.commons.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur on 12/21/2015.
 */
public class StringData extends TestData {

    private static final Logger log = Logger.getLogger(StringData.class.getName());

    private final String data;

    public StringData(String data) {
        this.data = data;
    }

    @Override
    public boolean exists() {
        return data != null;
    }

    @Override
    public InputStream openInputStream() {
        return new ByteArrayInputStream(data.getBytes());
    }

    @Override
    public Path getPath() {
        Path path = null;
        try {
            path = Files.createTempFile("", "");
            try (InputStream is = openInputStream()) {
                Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            log.log(Level.WARNING, "can't create path from string", e);
        }
        return path;
    }

    @Override
    public String getString() {
        return data;
    }
}
