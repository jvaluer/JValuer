package com.petukhovsky.jvaluer.commons.data;

import com.petukhovsky.jvaluer.commons.run.RunInfo;

import java.nio.file.Path;

/**
 * Created by Arthur on 12/25/2015.
 */
public class GeneratedData extends PathData {

    private final RunInfo info;

    public GeneratedData(Path path, RunInfo info) {
        super(path);
        this.info = info;
    }

    public RunInfo getInfo() {
        return info;
    }
}
