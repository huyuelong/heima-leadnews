package com.heima.tess4j;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Application {

    /**
     * 识别图片中的文字
     *
     * @param args
     */
    public static void main(String[] args) throws TesseractException {

        //创建实例
        ITesseract tesseract = new Tesseract();

        //设置字体库路径
//        tesseract.setDatapath("D:\\workspace\\tessdata");
        tesseract.setDatapath("D:\\94991\\Others\\tessdata");

        //设置语言 -->简体中文
        tesseract.setLanguage("chi_sim");

        File file = new File("D:\\94991\\Pictures\\Screenshots\\Snipaste_2025-07-23_17-02-04.png");

        //识别图片
        String result = tesseract.doOCR(file);

        System.out.println("识别的结果为：" + result.replaceAll("\\r|\\n", "-"));

    }
}
