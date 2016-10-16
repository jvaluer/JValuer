package com.petukhovsky.jvaluer.commons.exe;

import com.petukhovsky.jvaluer.commons.invoker.DefaultInvoker;
import com.petukhovsky.jvaluer.commons.invoker.Invoker;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Created by arthur on 16.10.16.
 */
public class Executable {
    private final Path path;
    private final Invoker invoker;

    public Executable(Path path, Invoker invoker) {
        Objects.requireNonNull(path, "Path to executable can't be null");
        Objects.requireNonNull(invoker, "Invoker can't be null. Should be DefaultInvoker instead");
        this.path = path;
        this.invoker = invoker;
    }

    public Executable(Path path) {
        this(path, new DefaultInvoker());
    }

    public Path getPath() {
        return path;
    }

    public Invoker getInvoker() {
        return invoker;
    }
}
