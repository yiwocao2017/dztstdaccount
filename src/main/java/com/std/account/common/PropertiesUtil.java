package com.std.account.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = PropertiesUtil.class
                .getResourceAsStream(configFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            props.load(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {
        public static String USER_URL = props.getProperty("USER_URL");

        public static String WECHAT_APP_BACKURL = props
            .getProperty("WECHAT_APP_BACKURL");

        public static String WECHAT_H5_BACKURL = props
            .getProperty("WECHAT_H5_BACKURL");

        public static String WECHAT_H5_QzBACKURL = props
            .getProperty("WECHAT_H5_QzBACKURL");

        public static String WECHAT_NATIVE_BACKURL = props
            .getProperty("WECHAT_NATIVE_BACKURL");

        public static String ALIPAY_APP_BACKURL = props
            .getProperty("ALIPAY_APP_BACKURL");

        public static String SELF_PAY_BACKURL = props
            .getProperty("SELF_PAY_BACKURL");
    }
}
