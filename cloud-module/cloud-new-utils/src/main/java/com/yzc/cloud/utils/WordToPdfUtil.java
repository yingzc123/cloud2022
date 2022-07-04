package com.yzc.cloud.utils;


import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;



/**
 * @author: SanZ
 * @DATE: 2022/7/1 14:49
 */
public class WordToPdfUtil extends BaseLicense{


    /**
     * 支持DOC, DOCX, OOXML, RTF, HTML, OpenDocument, PDF, EPUB, XPS, SWF等相互转换<br>
     *
     * @param wordfilePath [原始excel路径]
     * @param pdfFilePath  [输出路径]
     */
    public static Boolean wordConvertToPdf(String wordfilePath, String pdfFilePath) {
        // 验证License
        if (!getLicense()) {
            return false;
        }

        try {
            // 原始word路径
            Document doc = new Document(wordfilePath);
            // 输出路径
            File pdfFile = new File(pdfFilePath);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            doc.save(fileOS, SaveFormat.PDF);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
