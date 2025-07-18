package com.heima.utils.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.*;

/**
 * 字符串压缩工具类，支持 gzip / zip 编码及解码
 */
public class ZipUtils {

    /**
     * 使用 GZIP 进行压缩并 Base64 编码
     */
    public static String gzip(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(out)) {

            gzip.write(primStr.getBytes());
            gzip.finish();
            return Base64.getEncoder().encodeToString(out.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 GZIP 解压缩并 Base64 解码
     */
    public static String gunzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(compressedStr));
             GZIPInputStream ginzip = new GZIPInputStream(in)) {

            byte[] buffer = new byte[1024];
            int offset;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            return out.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 ZIP 压缩并 Base64 编码
     */
    public static String zip(String str) {
        if (str == null) {
            return null;
        }

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ZipOutputStream zout = new ZipOutputStream(out)) {

            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();

            return Base64.getEncoder().encodeToString(out.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用 ZIP 解压并 Base64 解码
     */
    public static String unzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        try (ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(compressedStr));
             ZipInputStream zin = new ZipInputStream(in);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            return out.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
