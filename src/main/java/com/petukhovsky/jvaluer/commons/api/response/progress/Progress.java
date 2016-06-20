package com.petukhovsky.jvaluer.commons.api.response.progress;

/**
 * Created by Arthur Petukhovsky on 6/21/2016.
 */
public class Progress {
    private String tokenId;
    private String submissionId;
    private String act;

    public Progress(String tokenId, String submissionId, String act) {
        this.tokenId = tokenId;
        this.submissionId = submissionId;
        this.act = act;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
