package com.petukhovsky.jvaluer.commons.test.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.test.TestVerdict;

/**
 * Created by arthur on 21.10.16.
 */
public class ScoreTestingResult extends TestingResult {

    private final double score;

    @JsonCreator
    public ScoreTestingResult(@JsonProperty("accepted") boolean accepted,
                              @JsonProperty("testsJudged") int testsJudged,
                              @JsonProperty("verdict") TestVerdict verdict,
                              @JsonProperty("testWithVerdict") Integer testWithVerdict,
                              @JsonProperty("score") double score) {
        super(accepted, testsJudged, verdict, testWithVerdict);
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
