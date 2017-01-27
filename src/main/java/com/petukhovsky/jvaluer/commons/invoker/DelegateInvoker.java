package com.petukhovsky.jvaluer.commons.invoker;

import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunOptions;

/**
 * Created by arthur on 24.12.16.
 */
public abstract class DelegateInvoker implements Invoker {
    private final Invoker delegate;

    public DelegateInvoker(Invoker delegate) {
        this.delegate = delegate;
    }

    public abstract RunOptions delegate(RunOptions opts);

    @Override
    public RunInfo run(RunOptions opts) {
        return delegate.run(delegate(opts));
    }
}
