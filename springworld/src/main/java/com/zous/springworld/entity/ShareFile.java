package com.zous.springworld.entity;

import java.sql.Date;

/**
 * Created by zhuoxiuwu on 2017/3/9.
 */
public class ShareFile {
    /*保存在七牛云空间时的指定前缀*/
    public static final String prefix ="/share/pdf/";
    private String _id;
    private String fileName;
    /**目前只支持pdf*/
    private String fileType;

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

    /**文件的上传时间*/

    private Date uploadTime;
    /*文件上传后的url*/
    private String url;
}
