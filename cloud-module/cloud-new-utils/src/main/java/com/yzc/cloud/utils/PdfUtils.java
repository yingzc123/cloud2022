package com.yzc.cloud.utils;

/**
 * @author: SanZ
 * @DATE: 2022/7/1 10:01
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件转PDF
 * <p>
 * Aspose下载地址：https://repository.aspose.com/repo/com/aspose/
 */

public class PdfUtils {

    public static void main(String[] args) {
       // ExcelToPdfUtil.excelConvertToPdf("D:\\xmlto\\save\\药房网新品上架.xlsx","D:\\xmlto\\save\\药房网新品上架.pdf");
        //WordToPdfUtil.wordConvertToPdf("D:\\xmlto\\save\\药房网新品上架.xlsx","D:\\xmlto\\save\\药房网新品上架1.pdf");
        ExecutorService executor = Executors.newFixedThreadPool(6) ;
        String path="D:\\xmlto\\save\\sm.pdf";
        executor.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            PdfToExcel.pdf2word(path);
        });
        executor.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            PdfToExcel.pdf2ppt(path);
        });
        executor.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            PdfToExcel.pdf2excel(path);
        });
        executor.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            PdfToExcel.pdf2Html(path);
        });







        /* //创建PdfDocument实例
        PdfDocument pdf = new PdfDocument();
        //加载示例PDF文档
        pdf.loadFromFile("D:\\xmlto\\save\\sm.pdf");
        //保存为Excel
        pdf.saveToFile("D:\\xmlto\\save\\smTest.doc", FileFormat.DOC);*/
    }









}
