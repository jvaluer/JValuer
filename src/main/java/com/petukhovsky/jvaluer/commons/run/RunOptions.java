package com.petukhovsky.jvaluer.commons.run;

import com.petukhovsky.jvaluer.util.UserAccount;

import java.nio.file.Path;
import java.util.*;

/**
 * Created by Arthur on 12/18/2015.
 */
public class RunOptions {

    private final String exe;

    private final Path folder;

    private final Path stdin;
    private final Path stdout;
    private final Path stderr;

    private final boolean trusted;
    private final RunLimits limits;

    private final UserAccount user;

    private final String[] args;
    private final Map<String, String> env;

    private final Map<String, Object> custom;

    public RunOptions(String exe, Path folder, Path stdin, Path stdout, Path stderr, boolean trusted, RunLimits limits, UserAccount user, String[] args, Map<String, String> env, Map<String, Object> custom) {
        this.exe = exe;
        this.folder = folder;
        this.stdin = stdin;
        this.stdout = stdout;
        this.stderr = stderr;
        this.trusted = trusted;
        this.limits = limits;
        this.user = user;
        this.args = args;
        this.env = env;
        this.custom = custom;
    }

    public String getExe() {
        return exe;
    }

    public Path getFolder() {
        return folder;
    }

    public Path getStdin() {
        return stdin;
    }

    public Path getStdout() {
        return stdout;
    }

    public Path getStderr() {
        return stderr;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public RunLimits getLimits() {
        return limits;
    }

    public UserAccount getUser() {
        return user;
    }

    public String[] getArgs() {
        return args;
    }

    public Map<String, String> getEnv() {
        return env;
    }

    public Map<String, Object> getCustom() {
        return custom;
    }

    @Override
    public String toString() {
        return "RunOptions{" +
                "exe='" + exe + '\'' +
                ", folder=" + folder +
                ", stdin=" + stdin +
                ", stdout=" + stdout +
                ", stderr=" + stderr +
                ", trusted=" + trusted +
                ", limits=" + limits +
                ", user=" + user +
                ", args=" + Arrays.toString(args) +
                ", env=" + env +
                ", custom=" + custom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunOptions that = (RunOptions) o;

        if (trusted != that.trusted) return false;
        if (exe != null ? !exe.equals(that.exe) : that.exe != null) return false;
        if (folder != null ? !folder.equals(that.folder) : that.folder != null) return false;
        if (stdin != null ? !stdin.equals(that.stdin) : that.stdin != null) return false;
        if (stdout != null ? !stdout.equals(that.stdout) : that.stdout != null) return false;
        if (stderr != null ? !stderr.equals(that.stderr) : that.stderr != null) return false;
        if (limits != null ? !limits.equals(that.limits) : that.limits != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(args, that.args)) return false;
        if (env != null ? !env.equals(that.env) : that.env != null) return false;
        return custom != null ? custom.equals(that.custom) : that.custom == null;
    }

    @Override
    public int hashCode() {
        int result = exe != null ? exe.hashCode() : 0;
        result = 31 * result + (folder != null ? folder.hashCode() : 0);
        result = 31 * result + (stdin != null ? stdin.hashCode() : 0);
        result = 31 * result + (stdout != null ? stdout.hashCode() : 0);
        result = 31 * result + (stderr != null ? stderr.hashCode() : 0);
        result = 31 * result + (trusted ? 1 : 0);
        result = 31 * result + (limits != null ? limits.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(args);
        result = 31 * result + (env != null ? env.hashCode() : 0);
        result = 31 * result + (custom != null ? custom.hashCode() : 0);
        return result;
    }

    static class Builder{

        String exe;
        Path folder;
        Path stdin;
        Path stdout;
        Path stderr;
        boolean trusted;
        RunLimits limits;
        UserAccount user;
        List<String> args;
        Map<String, String> env;
        Map<String, Object> custom;

        Builder() {
            args = new ArrayList<>();
            env = new HashMap<>();
            custom = new HashMap<>();
        }

        public Builder setExe(String exe) {
            this.exe = exe;
            return this;
        }

        public Builder setFolder(Path folder) {
            this.folder = folder;
            return this;
        }

        public Builder setStdin(Path stdin) {
            this.stdin = stdin;
            return this;
        }

        public Builder setStdout(Path stdout) {
            this.stdout = stdout;
            return this;
        }

        public Builder setStderr(Path stderr) {
            this.stderr = stderr;
            return this;
        }

        public Builder setTrusted(boolean trusted) {
            this.trusted = trusted;
            return this;
        }

        public Builder setLimits(RunLimits limits) {
            this.limits = limits;
            return this;
        }

        public Builder setUser(UserAccount user) {
            this.user = user;
            return this;
        }

        public Builder setArgs(String[] args) {
            return setArgs(Arrays.asList(args));
        }

        public Builder setArgs(List<String> args) {
            this.args = new ArrayList<>(args);
            return this;
        }

        public Builder setEnv(Map<String, String> env) {
            this.env = env;
            return this;
        }

        public Builder setCustom(Map<String, Object> custom) {
            this.custom = custom;
            return this;
        }

        public Builder putEnv(String key, String value) {
            this.env.put(key, value);
            return this;
        }

        public Builder putCustom(String key, Object value) {
            this.custom.put(key, value);
            return this;
        }

        public Builder appendArg(String arg) {
            args.add(arg);
            return this;
        }

        RunOptions build() {
            return new RunOptions(
                    exe,
                    folder,
                    stdin,
                    stdout,
                    stderr,
                    trusted,
                    limits,
                    user,
                    args.stream().toArray(String[]::new),
                    env,
                    custom
            );
        }
    }
}
