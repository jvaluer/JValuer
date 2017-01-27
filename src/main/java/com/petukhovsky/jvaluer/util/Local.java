package com.petukhovsky.jvaluer.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur on 12/21/2015.
 */
public class Local {

    private static Logger logger = Logger.getLogger(Local.class.getName());
    private static Runtime runtime = Runtime.getRuntime();

    public static Path loadResource(String name, Path copyTo) {
        try {
            try (InputStream is = Local.class.getResourceAsStream(name)) {
                Files.copy(is, copyTo, StandardCopyOption.REPLACE_EXISTING);
            }
            logger.info("resource " + name + " was loaded");
            return copyTo;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "resource " + name + " loading failed", e);
        }
        return null;
    }

    public static Process execute(String cmd) throws IOException {
        logger.fine("execute " + cmd);
        return runtime.exec(cmd);
    }

    public static Process execute(String[] cmd) throws IOException {
        logger.fine("execute " + Arrays.toString(cmd));
        return runtime.exec(cmd);
    }
}
