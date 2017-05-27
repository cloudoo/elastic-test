package com.csair.bi.oasearch.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by cloudoo on 2017/5/24.
 */
public class Document implements Serializable {

    private long id;
    private String category;
    private int docYear;
    private String fullDocId;//
    private String docName;
    private String attachEnumerate;
    private Date docDate;
    private int deptId;
    private String deptName;
    private int secret;
    private int flag;


    private int archiveFileNo;//附件文件名
    private String archiveNo;
    private String createTime;
    private String createUser;
    private String updateTm;
    private String updateUser;
    private String expireDestoryDate;
    private String annualYear;
    private long versionId;
    private String remark;
    private List<Attachment> attachmentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDocYear() {
        return docYear;
    }

    public void setDocYear(int docYear) {
        this.docYear = docYear;
    }

    public String getFullDocId() {
        return fullDocId;
    }

    public void setFullDocId(String fullDocId) {
        this.fullDocId = fullDocId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getAttachEnumerate() {
        return attachEnumerate;
    }

    public void setAttachEnumerate(String attachEnumerate) {
        this.attachEnumerate = attachEnumerate;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getArchiveFileNo() {
        return archiveFileNo;
    }

    public void setArchiveFileNo(int archiveFileNo) {
        this.archiveFileNo = archiveFileNo;
    }

    public String getArchiveNo() {
        return archiveNo;
    }

    public void setArchiveNo(String archiveNo) {
        this.archiveNo = archiveNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(String updateTm) {
        this.updateTm = updateTm;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getExpireDestoryDate() {
        return expireDestoryDate;
    }

    public void setExpireDestoryDate(String expireDestoryDate) {
        this.expireDestoryDate = expireDestoryDate;
    }

    public String getAnnualYear() {
        return annualYear;
    }

    public void setAnnualYear(String annualYear) {
        this.annualYear = annualYear;
    }

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
