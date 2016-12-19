package com.petukhovsky.jvaluer.util.io;

import com.petukhovsky.jvaluer.commons.data.TestData;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Arthur on 12/19/2015.
 */
public class FastScanner implements Closeable, AutoCloseable {

    final static int BUFFER_SIZE = 65536;
    private static final Logger log = Logger.getLogger(FastScanner.class.getName());
    private final BufferedReader br;

    private char[] buf = new char[BUFFER_SIZE];
    private int len = 0;
    private int it = 0;
    private boolean end = false;

    public FastScanner(TestData testData) {
        this(testData.openInputStream());
    }

    public FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is), BUFFER_SIZE);
    }

    private boolean isDelimiter(char c) {
        return c == ' ' || c == '\n' || c == '\r';
    }

    private void fillBuffer() {
        try {
            len = br.read(buf);
        } catch (IOException e) {
            log.log(Level.WARNING, "can't fill buffer", e);
        }
    }

    private void ensureBuffer() {
        if (it == len) {
            it = 0;
            fillBuffer();
            if (len == -1) end = true;
        }
    }

    private void moveNext() {
        while (!end) {
            ensureBuffer();
            if (!isDelimiter(buf[it])) return;
            while (it < len && isDelimiter(buf[it])) it++;
        }
    }

    public char nextChar() {
        if (end) throw new NullPointerException("End was reached");
        ensureBuffer();
        return buf[it++];
    }

    public String next() {
        moveNext();
        if (end) return null;
        StringBuilder sb = new StringBuilder();
        while (!end) {
            int l = it;
            while (++it < len && !isDelimiter(buf[it])) ;
            sb.append(buf, l, it - l);
            ensureBuffer();
            if (isDelimiter(buf[it])) break;
        }
        return sb.toString();
    }

    public int nextInt() {
        moveNext();
        if (!end && buf[it] == '-') {
            it++;
            return -nextInt();
        }
        int result = 0;
        while (!end) {
            int l = it;
            while (it < len && !isDelimiter(buf[it])) {
                result = (result * 10) + buf[it] - '0';
                it++;
            }
            ensureBuffer();
            if (end || isDelimiter(buf[it])) break;
        }
        return result;
    }

    public long nextLong() {
        moveNext();
        if (!end && buf[it] == '-') {
            it++;
            return -nextLong();
        }
        long result = 0;
        while (!end) {
            int l = it;
            while (it < len && !isDelimiter(buf[it])) {
                result = (result * 10) + buf[it] - '0';
                it++;
            }
            ensureBuffer();
            if (isDelimiter(buf[it])) break;
        }
        return result;
    }

    public boolean available() {
        return !end;
    }

    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            log.log(Level.WARNING, "can't close FastScanner", e);
        }
    }
}