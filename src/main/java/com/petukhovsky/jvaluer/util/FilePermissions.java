package com.petukhovsky.jvaluer.util;

/**
 * Created by petuh on 22.11.2016.
 */
class FilePermissions {

    private final boolean read;
    private final boolean write;
    private final boolean execute;

    FilePermissions(int mode) {
        execute = mode % 2 == 1;
        write = mode % 4 > 1;
        read = mode > 3;
    }

    FilePermissions(boolean read, boolean write, boolean execute) {
        this.read = read;
        this.write = write;
        this.execute = execute;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isWrite() {
        return write;
    }

    public boolean isExecute() {
        return execute;
    }

    public FilePermissions apply(FilePermissions to) {
        return new FilePermissions(to.read | read, to.write | write, to.execute | execute);
    }
}
