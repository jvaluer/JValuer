package com.petukhovsky.jvaluer.commons.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/11/2016.
 */
public class TestRequest {
    private final String type;
    private final Submission submission;
    private final String queueId;

    private final PackageInfo packageInfo;

    private final LaunchInfo launchInfo;

    @JsonCreator
    public TestRequest(@JsonProperty("queueId") String queueId,
                       @JsonProperty("packageInfo") PackageInfo packageInfo,
                       @JsonProperty("submission") Submission submission) {
        this.packageInfo = packageInfo;
        this.launchInfo = null;
        this.submission = submission;
        this.queueId = queueId;
        this.type = "package";
    }

    public TestRequest(String queueId, LaunchInfo launchInfo, Submission submission) {
        this.launchInfo = launchInfo;
        this.packageInfo = null;
        this.submission = submission;
        this.queueId = queueId;
        this.type = "launch";
    }

    public String getType() {
        return type;
    }

    public Submission getSubmission() {
        return submission;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public LaunchInfo getLaunchInfo() {
        return launchInfo;
    }

    public String getQueueId() {
        return queueId;
    }
}
