package com.petukhovsky.jvaluer.commons.checker;

import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.util.io.FastScanner;
import com.petukhovsky.jvaluer.util.string.StringUtils;

import java.util.Objects;

/**
 * Created by Arthur on 12/19/2015.
 */
public class TokenChecker extends Checker {
    @Override
    public CheckResult check(TestData in, TestData answer, TestData out) {
        if (!out.exists()) return new CheckResult(false, "Presentation error");
        if (!in.exists() || !answer.exists()) return new CheckResult(false, "Internal error - missing files");
        FastScanner answerScanner = new FastScanner(answer);
        FastScanner outScanner = new FastScanner(out);
        int token = 0;
        String comment;
        boolean correct = false;
        while (true) {
            String answerString = answerScanner.next();
            String outString = outScanner.next();
            if (!Objects.equals(answerString, outString)) {
                if (outString == null) comment = "Expected " + StringUtils.truncate(answerString, 10) + " but reached end of file";
                else if (answerString == null) comment = "Expected end of file, but read " + StringUtils.truncate(outString, 10);
                else comment = "Expected " + answerString + " but read " + outString;
                break;
            }
            if (answerString == null) {
                correct = true;
                comment = "ok " + token + " tokens";
                break;
            }
            token++;
        }
        answerScanner.close();
        outScanner.close();
        return new CheckResult(correct, comment);
    }
}
