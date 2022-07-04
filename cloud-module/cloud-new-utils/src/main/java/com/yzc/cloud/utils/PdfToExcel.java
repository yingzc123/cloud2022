package com.yzc.cloud.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;

import java.io.*;

/**
 * @author: SanZ
 * @DATE: 2022/7/1 15:07
 */
public class PdfToExcel {
   private static String savePath="D:\\xmlto\\save\\";


    /**
     * 文件File类型转byte[]
     *
     * @param file 文件对象
     * @return
     */
    public static byte[] fileToByte(File file) {
        byte[] fileBytes = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }




    //转word
    public static  byte[]  pdf2word(InputStream inputStream,String fileName) {
        long old = System.currentTimeMillis();
        String wordPath="";
        try {
             wordPath = savePath+fileName;
            FileOutputStream os = new FileOutputStream(wordPath);
            Document doc = new Document(inputStream);
            doc.save(os, SaveFormat.DocX);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
        File file = new File(wordPath);
        byte[] bytes = fileToByte(file);
        file.delete();
        return   bytes;
    }


    //转word
   public static void pdf2word(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            String wordPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".docx";
            FileOutputStream os = new FileOutputStream(wordPath);
            Document doc = new Document(pdfPath);
            doc.save(os, SaveFormat.DocX);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }

    //转ppt
    public static void pdf2ppt(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            //新建一个word文档
            String wordPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".pptx";
            FileOutputStream os = new FileOutputStream(wordPath);
            //doc是将要被转化的word文档
            Document doc = new Document(pdfPath);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.Pptx);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 PPT 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 PPT 失败...");
            e.printStackTrace();
        }
    }

    //转excel
    public static void pdf2excel(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            String wordPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".xlsx";
            FileOutputStream os = new FileOutputStream(wordPath);
            Document doc = new Document(pdfPath);
            doc.save(os, SaveFormat.Excel);
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 EXCEL 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 EXCEL 失败...");
            e.printStackTrace();
        }
    }

    //转html
    public static void pdf2Html(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            String htmlPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".html";
            Document doc = new Document(pdfPath);
            doc.save(htmlPath, SaveFormat.Html);
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 HTML 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 HTML 失败...");
            e.printStackTrace();
        }
    }

    //转图片
    public static void pdf2image(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            Resolution resolution = new Resolution(300);
            String dataDir = pdfPath.substring(0, pdfPath.lastIndexOf("."));
            File imageDir = new File(dataDir + "_images");
            if (!imageDir.exists()) {
                imageDir.mkdirs();
            }
            Document doc = new Document(pdfPath);
            PngDevice pngDevice = new PngDevice(resolution);
            for (int pageCount = 1; pageCount <= doc.getPages().size(); pageCount++) {
                OutputStream imageStream = new FileOutputStream(imageDir + "/" + pageCount + ".png");
                pngDevice.process(doc.getPages().get_Item(pageCount), imageStream);
                imageStream.close();
            }
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 PNG 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 PNG 失败...");
            e.printStackTrace();
        }
    }

    //转txt
    public static void pdf2txt(String pdfPath) {
        long old = System.currentTimeMillis();
        Document pdfDocument = new Document(pdfPath);
        TextAbsorber ta = new TextAbsorber();
        ta.visit(pdfDocument);
        String txtPath = pdfPath.substring(0, pdfPath.lastIndexOf(".")) + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath));
            writer.write(ta.getText());
            writer.close();
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 TXT 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (IOException e) {
            System.out.println("Pdf 转 TXT 失败...");
            e.printStackTrace();
        }
    }




}
