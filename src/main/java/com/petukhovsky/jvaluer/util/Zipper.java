package com.petukhovsky.jvaluer.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Arthur Petukhovsky on 6/14/2016.
 */
public class Zipper implements Closeable, AutoCloseable {

    private final ObjectMapper objectMapper;

    private ZipOutputStream zos;

    public Zipper(Path path, int level) throws FileNotFoundException {
        this.objectMapper = new ObjectMapper();

        FileOutputStream fos = new FileOutputStream(path.toFile());
        zos = new ZipOutputStream(fos);
        zos.setMethod(ZipOutputStream.DEFLATED);
        zos.setLevel(level);
    }

    public Zipper(Path path) throws FileNotFoundException {
        this(path, 8);
    }

    public void writeFile(String name, byte[] bytes) throws IOException {
        zos.putNextEntry(new ZipEntry(name));
        zos.write(bytes);
    }

    public void writeFile(String name, String content) throws IOException {
        writeFile(name, content.getBytes());
    }

    public void writeJson(String name, Object object) throws IOException {
        writeFile(name, objectMapper.writeValueAsBytes(object));
    }

    public void writeFile(String name, Path source) throws IOException {
        zos.putNextEntry(new ZipEntry(name));
        Files.copy(source, zos);
    }

    @Override
    public void close() throws IOException {
        zos.close();
    }
}
