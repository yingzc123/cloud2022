package com.yzc.cloud.utils;

import com.aspose.cells.License;

import java.io.InputStream;

/**
 * @author: SanZ
 * @DATE: 2022/7/1 14:51
 */
public class BaseLicense {

    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = ExcelToPdfUtil.class.getClassLoader().getResourceAsStream("\\license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
