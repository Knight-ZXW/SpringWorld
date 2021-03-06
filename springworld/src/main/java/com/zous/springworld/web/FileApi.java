package com.zous.springworld.web;

import com.zous.springworld.service.ShareFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import qiniu.support.UploadManager;
import qiniu.support.UploadToken;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

/**
 * Created by zhuoxiuwu on 2017/3/9.
 */
@RestController
public class FileApi {
    private static final Logger logger = Logger.getLogger(FileApi.class.getSimpleName());
    @Autowired
    ShareFileService shareFileService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                File dir = new File(File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

    @RequestMapping(value = "/qiniuUpload", method = RequestMethod.GET)
    public String qiniuUploadFileHandler() {
        return "qiniu_upload";
    }

    @RequestMapping(value = "getUploadToken")
    public UploadToken getUploadToken() {
        UploadManager uploadManager = new UploadManager();
        UploadToken uploadToken = uploadManager.createUploadToken();
//        int success = shareFileService.insertShareFile("fileName");
        return uploadToken;
    }
}
