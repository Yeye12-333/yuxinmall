package com.example.mallelectron.controller;


import cn.hutool.core.lang.ObjectId;
import com.example.mallelectron.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@Controller
public class UploadController {

    @Value("${upload-path}")
    private String uploadPath;

    @RequestMapping("/upload")
    public Result upload(@RequestParam MultipartFile file) throws IOException {
        String filename = ObjectId.next() + "_" + file.getOriginalFilename();
        file.transferTo(new File(uploadPath + File.separator + filename));
        return Result.ok().data("filename", filename);
    }


}
