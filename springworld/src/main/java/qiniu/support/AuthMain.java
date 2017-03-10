package qiniu.support;

import com.qiniu.util.Auth;

import java.util.HashMap;
/**
 * Created by zhuoxiuwu on 2017/3/9.
 */
public class AuthMain {

    public static void main(String[] args) {
        HashMap<String, String> qiniuConfig = QiniuUtil.getQiniuConfig();
        String accessKey = qiniuConfig.get("AccessKey");
        String secretKey = qiniuConfig.get("SecretKey");
        String scopePdf = qiniuConfig.get("Scope-pdf");
        System.out.println(accessKey + ":" + secretKey);
        System.out.print("scopePdf dir is "+scopePdf);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(scopePdf);
        System.out.println("uptoken is "+upToken);

    }
}
