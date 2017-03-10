package com.zous.springworld.service;

import com.zous.springworld.entity.ShareFile;
import com.zous.springworld.mapper.ShareFileMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhuoxiuwu on 2017/3/10.
 */
public class ShareFileService {
    @Autowired
    ShareFileMapper shareFileMapper;

    public int insertShareFile(String fileName) {
        ShareFile shareFile = new ShareFile();
        shareFile.setFileName(fileName);
        shareFile.setFileType("pdf");
        return shareFileMapper.addShareFile(shareFile);
    }
}
