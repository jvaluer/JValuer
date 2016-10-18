package com.petukhovsky.jvaluer.commons.gen;

import com.petukhovsky.jvaluer.commons.data.GeneratedData;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.RunLimits;

/**
 * Created by arthur on 14.10.16.
 */
public interface Generator {
    GeneratedData generate(TestData in, RunLimits limits, String... args);
}
