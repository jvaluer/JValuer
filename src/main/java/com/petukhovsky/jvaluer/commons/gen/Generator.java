package com.petukhovsky.jvaluer.commons.gen;

import com.petukhovsky.jvaluer.commons.data.GeneratedData;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.RunLimits;

/**
 * Created by arthur on 14.10.16.
 */
public abstract class Generator {
    public GeneratedData generate(TestData in, RunLimits limits, String... args) {
        return generate(RunLimits.ofTime(10000L), args);
    }

    public GeneratedData generate(RunLimits limits, String... args) {
        return generate(args);
    }

    public abstract GeneratedData generate(String... args);
}
