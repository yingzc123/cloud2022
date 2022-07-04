package com.yzc.cloud.utils;

import java.io.File;
import java.io.FileOutputStream;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;


/**
 * @author: SanZ
 * @DATE: 2022/7/1 14:50
 */
public class ExcelToPdfUtil extends BaseLicense{



    /**
     * 支持DOC, DOCX, OOXML, RTF, HTML, OpenDocument, PDF, EPUB, XPS, SWF等相互转换<br>
     *
     * @param excelfilePath [原始excel路径]
     * @param pdfFilePath   [输出路径]
     */

    public static Boolean excelConvertToPdf(String excelfilePath, String pdfFilePath) {
        // 验证License
        if (!getLicense()) {
            return false;
        }

        try {
            // 原始excel路径
            Workbook wb = new Workbook(excelfilePath);
            // 输出路径
            File pdfFile = new File(pdfFilePath);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            wb.save(fileOS, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
