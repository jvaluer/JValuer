package com.petukhovsky.jvaluer.commons.builtin;

import com.petukhovsky.jvaluer.commons.checker.Checker;
import com.petukhovsky.jvaluer.commons.gen.Generator;

/**
 * Created by arthur on 14.10.16.
 */
public interface JValuerBuiltin {
    Checker checker(String id);
    Generator generator(String id);
}
