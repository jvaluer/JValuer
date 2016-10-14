package com.petukhovsky.jvaluer.commons.lang;

import com.petukhovsky.jvaluer.commons.compiler.Compiler;
import com.petukhovsky.jvaluer.commons.invoker.DefaultInvoker;
import com.petukhovsky.jvaluer.commons.invoker.Invoker;

/**
 * Created by arthur on 14.10.16.
 */
public class Language {

    private final String name;
    private final Compiler compiler;
    private final Invoker invoker;

    public Language(String name, Compiler compiler, Invoker invoker) {
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
}