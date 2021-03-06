package com.sunlion.imagecachedemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/12/11 0011.
 */

public class MD5Util {
    public MD5Util() {
    }

    /**
     * md5加密算法
     * @param password
     * @return
     */

    public static String encodeMd5(String password){
        try {
            //得到信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            //通过信息摘要器,将密码字符串转换成字节字符串
            byte[] bys = digest.digest(password.getBytes());

            //定义一个字符串缓存区存储字符串
            StringBuffer stringBuffer = new StringBuffer();

            //遍历得到每一个字节
            for (byte b : bys){
                //每个字符串都与上一个十六进制,得到十进制数
                int number = b & 0xff;
                //将十进制数转换成十六进制数进行显示
                String str = Integer.toHexString(number);
                //如果得到的十六进制数只有四位,则需将其不全为八位
                if(str.length() == 1){
                    stringBuffer.append("0");
                }
                //将结果添加到缓存区
                stringBuffer.append(str);
            }
            //返回结果
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
