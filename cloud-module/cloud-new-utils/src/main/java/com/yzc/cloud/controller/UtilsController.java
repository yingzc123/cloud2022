package com.yzc.cloud.controller;

import com.yzc.cloud.utils.PdfToExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: SanZ
 * @DATE: 2022/7/1 10:03
 */

@RestController
@RequestMapping("utils")
@Slf4j
public class UtilsController {



    @PostMapping("replace")
    public void whit(@RequestParam("file") MultipartFile file, HttpServletResponse response,String type) throws IOException {
        //设置响应信息
        response.setContentType("application/octet-stream");
        String originalFilename = file.getOriginalFilename();
        // filename为文件下载后保存的文件名，可自行设置，但是注意文件名后缀，要和原来的保持一致
        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."))+".docx";
        response.setHeader("Content-Disposition", "attachment; filename=" + name);
        byte[] bytes = PdfToExcel.pdf2word(file.getInputStream(), name);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            // 输出到客户端
            out.write(bytes);
        } catch (Exception e) {
            log.error("",e);
        }

    }


}
