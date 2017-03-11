package qiniu.support;

/**
 * Created by zhuoxiuwu on 2017/3/10.
 */

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.util.HashMap;

/**
 */
public class UploadManager {

    private static String SHARE_FILE_BUCKET = "share-pdf";
    private static HashMap<String, String> qiniuConfig;

    private Auth auth;

    public UploadManager() {
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

    public  UploadToken createUploadToken() {
        String token = getAuth().uploadToken(SHARE_FILE_BUCKET);
        UploadToken uploadToken = new UploadToken();
        uploadToken.setToken(token);
        return uploadToken;
    }
}
