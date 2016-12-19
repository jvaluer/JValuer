package com.petukhovsky.jvaluer.commons.local;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur on 12/21/2015.
 */
public class Local {

    private static Logger logger = Logger.getLogger(Local.class.getName());

    public static Path loadResource(Path path, String name) {
        try {
            try (InputStream is = Local.class.getResourceAsStream(name)) {
                Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
            }
            logger.info("resource " + name + " was loaded");
            return path;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "resource " + name + " loading failed", e);
        }
        return null;
    }

    public static Process execute(String cmd) throws IOException {
        logger.fine("execute " + cmd);
        if (OS.isWindows()) return Runtime.getRuntime().exec(cmd);
        else return Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
    }

    public static Process execute(String[] cmd) throws IOException {
        logger.fine("execute " + Arrays.toString(cmd));
        if (OS.isWindows()) return Runtime.getRuntime().exec(cmd);
        else {
            String[] args = new String[cmd.length + 2];
            args[0] = "bash";
            args[1] = "-c";
            System.arraycopy(cmd, 0, args, 2, cmd.length);
            return Runtime.getRuntime().exec(args);
        }
    }
}
