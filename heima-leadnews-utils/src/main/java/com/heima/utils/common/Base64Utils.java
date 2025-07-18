package com.heima.utils.common;

import java.util.Base64;

public class Base64Utils {

    /**
     * 解码
     * @param base64 Base64 编码的字符串
     * @return 解码后的字节数组，失败返回 null
     */
    public static byte[] decode(String base64) {
        try {
            // Base64 解码
            return Base64.getDecoder().decode(base64);
        } catch (IllegalArgumentException e) {
            // 解码失败（例如字符串格式错误）
            return null;
        }
    }

    /**
     * 编码
     * @param data 要编码的字节数组
     * @return Base64 编码字符串
     */
    public static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
