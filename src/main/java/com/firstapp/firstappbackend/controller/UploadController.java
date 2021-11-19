package com.firstapp.firstappbackend.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping(value = "/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("notespic") MultipartFile file) {  //括号里接收数据
        //文件重命名  避免不同用户相同图片重合
        if (file != null && file.getOriginalFilename() != null) {
            //获取文件扩展名
            String originalFileName = file.getOriginalFilename();  // **.png
            String extend = originalFileName.substring(originalFileName.lastIndexOf("."));
            //重新生成唯一的扩展名
            String newName = UUID.randomUUID().toString();
            File file1 = new File("D:" + File.separator + "upload", newName + extend);
            try {
                file.transferTo(file1);  //保存文件
                return file1.getAbsolutePath();  //返回给接口的是文件路径
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
