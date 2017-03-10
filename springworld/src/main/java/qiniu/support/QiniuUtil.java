package qiniu.support;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by zhuoxiuwu on 2017/3/9.
 */
public class QiniuUtil {
    public static HashMap<String,String> getQiniuConfig(){
        InputStream in =null;
        HashMap<String,String> qiniuConfig = null;
        try {
            Properties pro = new Properties();
            in = AuthMain.class.getClassLoader().getResourceAsStream("qiniu-config.properties");
            pro.load(in);
            qiniuConfig= new HashMap<>();
            Iterator<String> iterator = pro.stringPropertyNames().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                qiniuConfig.put(key,pro.getProperty(key));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return qiniuConfig;
    }
}
