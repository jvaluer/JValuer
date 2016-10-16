package com.petukhovsky.jvaluer.commons.lang;

import com.petukhovsky.jvaluer.commons.compiler.Compiler;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.jvaluer.commons.invoker.DefaultInvoker;
import com.petukhovsky.jvaluer.commons.invoker.Invoker;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Created by arthur on 14.10.16.
 */
public class Language {

    private final String name;
    private final Compiler compiler;
    private final Invoker invoker;

    public Language(String name, Compiler compiler, Invoker invoker) {
        Objects.requireNonNull(name, "Name can't be null");
        Objects.requireNonNull(compiler, "Compiler can't be null");
        Objects.requireNonNull(invoker, "Invoker can't be null");
        this.name = name;
        this.compiler = compiler;
        this.invoker = invoker;
    }

    public Language(String name, Compiler compiler) {
        this(name, compiler, new DefaultInvoker());
    }

    public Compiler compiler() {
        return compiler;
    }

    public Invoker invoker() {
        return invoker;
    }

    public String name() {
        return name;
    }

    public Executable createExecutable(Path path) {
        return new Executable(path, invoker);
    }
}