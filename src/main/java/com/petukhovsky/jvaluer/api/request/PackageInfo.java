package com.petukhovsky.jvaluer.api.request;

/**
 * Created by Arthur Petukhovsky on 6/13/2016.
 */
public class PackageInfo { //TODO
    private final String id;
    private final String revision;
    private final String url;

    public PackageInfo(String id, String revision, String url) {
        this.id = id;
        this.revision = revision;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getRevision() {
        return revision;
    }

    public String getUrl() {
        return url;
    }
}
