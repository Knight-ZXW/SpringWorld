package qiniu.support;

/**
 * Created by zhuoxiuwu on 2017/3/10.
 */

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.util.HashMap;

/**
 * 七牛云上传的管理帮助类
 */
public class UploadManager {

    private static String SHARE_FILE_BUCKET = "share-pdf";
    //我们需要限制 文件上传后保存的文件名，限制文件后缀，
    /*七牛云用到的上传凭证*/
    private Auth auth;
    private static HashMap<String, String> qiniuConfig;


    private UploadManager() {
        qiniuConfig = QiniuUtil.getQiniuConfig();
    }

    private static Auth getAuth() {
        return Auth.create(qiniuConfig.get("AccessKey"), qiniuConfig.get("SecretKey"));
    }

    /**
     * 自定义七牛云上传后的 回调Json内容
     * <a HREF="http://www.w3.org/TR/html4">见七牛云文档</a>
     *
     * @return
     */
    private StringMap generateReturnBody() {
        return null;
    }

    public static UploadToken createUploadToken() {
        String token = getAuth().uploadToken(SHARE_FILE_BUCKET);
        UploadToken uploadToken = new UploadToken();
        uploadToken.setToken(token);
        return uploadToken;
    }
}
