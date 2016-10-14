package com.petukhovsky.jvaluer;

import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;
import com.petukhovsky.jvaluer.commons.compiler.Compiler;
import com.petukhovsky.jvaluer.commons.invoker.Invoker;
import com.petukhovsky.jvaluer.commons.lang.Language;
import com.petukhovsky.jvaluer.commons.lang.Languages;
import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunOptions;
import com.petukhovsky.jvaluer.commons.source.Source;

import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

/**
 * Created by arthur on 14.10.16.
 */
public interface JValuer {
    Path loadResource(String name, String resource);
    void cleanTemp();
    Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs);
    Path createTempExe();
    Path createTempDir();
    CompilationResult compile(Language language, Path source, String... defines);
    CompilationResult compile(Compiler compiler, Path source, String... defines);
    CompilationResult compile(Source source, String... defines);
    Languages getLanguages();
    RunInfo invokeDefault(RunOptions options);
    RunInfo invoke(Invoker invoker, RunOptions options);
}
