package com.guangfuxiong.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping(value = "upload.do")
    public String upload(){
        return "page/file";
    }
    @RequestMapping(value = "photo.do")//必须配置文件上传解析器，xml
    public String photo(MultipartFile photo) throws IOException {
        /*FileOutputStream fileOutputStream = new FileOutputStream(
                new File("D:\\"+photo.getOriginalFilename())
        );
        fileOutputStream.write(photo.getBytes());
        fileOutputStream.close();*/
        FileUtils.writeByteArrayToFile(new File("D:\\示例图片\\"+photo.getOriginalFilename()),photo.getBytes());
        return "page/hello";
    }
}
