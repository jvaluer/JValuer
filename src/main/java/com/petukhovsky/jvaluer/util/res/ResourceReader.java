package com.petukhovsky.jvaluer.util.res;

import java.io.InputStream;

/**
 * Created by arthur on 16.10.16.
 */
public interface ResourceReader {
    String readString(String path);
    InputStream openInputStream(String path);
    boolean exists(String path);
}
