package com.petukhovsky.jvaluer.util.os;

import java.util.function.Supplier;

/**
 * Created by Arthur Petukhovsky on 5/21/2016.
 */
public class OSSupplier<T> {

    private OSValue<Supplier<T>> value;

    public OSSupplier() {
        value = new OSValue<>();
    }

    public OSSupplier<T> windows(Supplier<T> supplier) {
        value.windows(supplier);
        return this;
    }

    public OSSupplier<T> windows32(Supplier<T> supplier) {
        value.windows32(supplier);
        return this;
    }

    public OSSupplier<T> windows64(Supplier<T> supplier) {
        value.windows64(supplier);
        return this;
    }

    public OSSupplier<T> unix(Supplier<T> supplier) {
        value.unix(supplier);
        return this;
    }

    public OSSupplier<T> osx(Supplier<T> supplier) {
        value.osx(supplier);
        return this;
    }

    public T get() {
        return value.get().get();
    }

    public T orElse(T other) {
        return value.value().isPresent() ? get() : other;
    }

    public T orElse(Supplier<T> other) {
        return value.orElse(other).get();
    }

    public T orNull() {
        return orElse(() -> null);
    }
}
