package com.petukhovsky.jvaluer.commons.builtin;

import com.petukhovsky.jvaluer.commons.checker.Checker;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.commons.invoker.Invoker;

/**
 * Created by arthur on 14.10.16.
 */
public interface JValuerBuiltin {
    Checker checker(String id);
    Generator generator(String id);
    Invoker invoker(String id);
}
