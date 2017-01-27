package com.petukhovsky.jvaluer.commons.compiler;

import com.petukhovsky.jvaluer.util.Local;
import com.petukhovsky.jvaluer.util.fs.FilesUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by petuh on 2/23/2016.
 */
public class RunnableCompiler extends Compiler {

    private static Logger logger = Logger.getLogger(RunnableCompiler.class.getName());

    private final String exe;
    private final String pattern;
    private final int timeout;

    public RunnableCompiler(String exe, String pattern) {
        this(exe, pattern, 60);
    }

    public RunnableCompiler(String exe, String pattern, int timeout) {
        this.exe = exe;
        this.pattern = pattern;
        this.timeout = timeout;
    }

    @Override
    public CompilationResult compile(Path output, Path source, String... defines) {
        output = output.toAbsolutePath();
        source = source.toAbsolutePath();
        logger.info("Compile " + source + " to " + output + " with defines = " + Arrays.toString(defines));
        FilesUtils.removeRecursiveForce(output);
        String cmd = exe + " "
                + pattern.replace("{defines}", defines.length > 0 ? "-D " + String.join(" -D") : "")
                .replace("{output}", "\"" + output.toString() + "\"")
                .replace("{source}", "\"" + source.toString() + "\"");
        try {
            Process process = Local.execute(cmd);
            process.waitFor(timeout, TimeUnit.SECONDS);
            if (process.isAlive()) {
                process.destroyForcibly();
                return new CompilationResult(output, "Time limit exceeded", false);
            }
            String comment = IOUtils.toString(process.getErrorStream(), "UTF-8");
            comment += IOUtils.toString(process.getInputStream(), "UTF-8");
            if (Files.exists(output)) FilesUtils.chmod(output, 777);
            return new CompilationResult(output, comment, Files.exists(output));
        } catch (IOException | InterruptedException e) {
            logger.log(Level.SEVERE, "Compilation failed", e);
            return new CompilationResult(output, "Something went wrong", false);
        }
    }
}
