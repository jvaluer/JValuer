package com.petukhovsky.jvaluer.util.os;

import java.util.Optional;

/**
 * Created by Arthur Petukhovsky on 5/21/2016.
 */
public class OSValue<T> {

    private Optional<T> value;

    public OSValue() {
        value = Optional.empty();
    }

    public OSValue<T> windows(T value) {
        if (OS.isWindows()) this.value = Optional.of(value);
        return this;
    }

    public OSValue<T> windows32(T value) {
        if (OS.isWindows() && !OS.is64Bit()) this.value = Optional.of(value);
        return this;
    }

    public OSValue<T> windows64(T value) {
        if (OS.isWindows() && OS.is64Bit()) this.value = Optional.of(value);
        return this;
    }

    public OSValue<T> unix(T value) {
        if (OS.isUnix()) this.value = Optional.of(value);
        return this;
    }

    public OSValue<T> osx(T value) {
        if (OS.isOSX()) this.value = Optional.of(value);
        return this;
    }

    public T get() {
        return value.get();
    }

    public T orElse(T other) {
        return value.orElse(other);
    }

    public Optional<T> value() {
        return value;
    }
}
