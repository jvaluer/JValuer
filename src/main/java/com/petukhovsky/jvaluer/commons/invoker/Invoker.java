package com.petukhovsky.jvaluer.commons.invoker;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunOptions;

/**
 * Created by arthur on 14.10.16.
 */
public interface Invoker {
    RunInfo run(JValuer jValuer, RunOptions runOptions);
}
