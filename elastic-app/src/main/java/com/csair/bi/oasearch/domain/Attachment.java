package com.csair.bi.oasearch.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by cloudoo on 2017/5/25.
 */
public class Attachment implements Serializable {

    private long docId;
    private long attachId;
    private String name;
    private String url;
    private String type;
    private Timestamp upTm;

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public long getAttachId() {
        return attachId;
    }

    public void setAttachId(long attachId) {
        this.attachId = attachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getUpTm() {
        return upTm;
    }

    public void setUpTm(Timestamp upTm) {
        this.upTm = upTm;
    }
}
