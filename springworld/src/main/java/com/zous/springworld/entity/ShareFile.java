package com.zous.springworld.entity;

import java.sql.Date;

/**
 * Created by zhuoxiuwu on 2017/3/9.
 */
public class ShareFile {
    public static final String prefix ="/share/pdf/";
    private String _id;
    private String fileName;
    private String fileType;

    private Date uploadTime;
    private String url;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
