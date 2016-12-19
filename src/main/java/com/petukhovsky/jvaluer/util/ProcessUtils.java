package com.petukhovsky.jvaluer.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by arthur on 19.12.16.
 */
public class ProcessUtils {
    public static String readStdout(Process process) throws IOException {
        return IOUtils.toString(process.getInputStream(), "UTF-8");
    }
}
