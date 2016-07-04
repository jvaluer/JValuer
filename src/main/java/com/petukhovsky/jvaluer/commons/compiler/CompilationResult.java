package com.petukhovsky.jvaluer.commons.compiler;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Arthur on 12/25/2015.
 */
public class CompilationResult {

    @JsonIgnore
    private Path exe;

    private String comment;
    private boolean success;

    public CompilationResult(Path exe, String comment, boolean success) {
        this.exe = exe;
        this.comment = comment;
        this.success = success;
    }

    @JsonCreator
    public CompilationResult(@JsonProperty("comment") String comment, @JsonProperty("success") boolean success) {
        this.comment = comment;
        this.success = success;
        this.exe = null;
    }

    public boolean exists() {
        return exe != null && Files.exists(exe) && success;
    }

    public boolean isSuccess() {
        return success;
    }

    public Path getExe() {
        return exe;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return (isSuccess() ? "Compiled successfully" : "Compilation error") + System.lineSeparator() + getComment();
    }

}
