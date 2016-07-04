package com.petukhovsky.jvaluer.commons.run;

import com.petukhovsky.jvaluer.commons.local.UserAccount;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur on 12/18/2015.
 */
public class RunOptions {

    private final Path folder;
    private final Path stdinForward;
    private final Path stdoutForward;
    private final Path stderrForward;
    private final Path dllInject;
    private final boolean trusted;
    private final UserAccount userAccount;
    private final RunLimits limits;
    private final String args;

    private final Map<String, Object> custom;

    public RunOptions(Path folder, Path stdinForward, Path stdoutForward, Path stderrForward, Path dllInject, boolean trusted, UserAccount userAccount, RunLimits limits, String args, Map<String, Object> custom) {
        if (limits == null) throw new IllegalArgumentException("limits can't be null");
        if (args == null) throw new IllegalArgumentException("args can't be null");
        if (custom == null) throw new IllegalArgumentException("custom args can't be null");
        this.folder = folder;
        this.stdinForward = stdinForward;
        this.stdoutForward = stdoutForward;
        this.stderrForward = stderrForward;
        this.dllInject = dllInject;
        this.trusted = trusted;
        this.userAccount = userAccount;
        this.limits = limits;
        this.args = args;
        this.custom = Collections.unmodifiableMap(custom);
    }

    public RunOptions() {
        this(null, null, null, null, null, false, null, RunLimits.unlimited(), "", new HashMap<>());
    }

    public RunOptions setCustom(Map<String, Object> custom) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public RunOptions putCustomArg(String key, Object value) {
        Map<String, Object> custom = new HashMap<>(this.custom);
        custom.put(key, value);
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Path getFolder() {
        return folder;
    }

    public RunOptions setFolder(Path folder) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Path getStdinForward() {
        return stdinForward;
    }

    public RunOptions setStdinForward(Path stdinForward) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Path getStdoutForward() {
        return stdoutForward;
    }

    public RunOptions setStdoutForward(Path stdoutForward) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Path getStderrForward() {
        return stderrForward;
    }

    public RunOptions setStderrForward(Path stderrForward) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Path getDllInject() {
        return dllInject;
    }

    public RunOptions setDllInject(Path dllInject) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public boolean isTrusted() {
        return trusted;
    }

    public RunOptions setTrusted(boolean trusted) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public RunOptions setUserAccount(UserAccount userAccount) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public RunLimits getLimits() {
        return limits;
    }

    public RunOptions setLimits(RunLimits limits) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public String getArgs() {
        return args;
    }

    public RunOptions setArgs(String args) {
        return new RunOptions(folder, stdinForward, stdoutForward, stderrForward, dllInject, trusted, userAccount, limits, args, custom);
    }

    public Object get(String key) {
        return custom.get(key);
    }

    public boolean containsKey(String key) {
        return custom.containsKey(key);
    }
}
