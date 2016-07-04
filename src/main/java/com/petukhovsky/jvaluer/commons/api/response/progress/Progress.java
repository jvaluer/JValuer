package com.petukhovsky.jvaluer.commons.api.response.progress;

/**
 * Created by Arthur Petukhovsky on 6/21/2016.
 */
public class Progress {
    private final String tokenId;
    private final String submissionId;
    private final String act;

    public Progress(String tokenId, String submissionId, String act) {
        this.tokenId = tokenId;
        this.submissionId = submissionId;
        this.act = act;
    }

    public String getTokenId() {
        return tokenId;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public String getAct() {
        return act;
    }
}
