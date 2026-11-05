package com.sonnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Controller
public class FileUploadController {

    // 跳转到文件上传页面
    @GetMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }

    // 进行文件上传，如果是多文件上传，使用MultipartFile[]
    @PostMapping("/upload")
    public String upload(String email, String username, MultipartFile headerImg, MultipartFile[] photos) throws Exception {
        File uploadDirectory = new File("D:\\upload");
        Files.createDirectories(uploadDirectory.toPath());

        // 单文件上传
        if (headerImg != null && !headerImg.isEmpty()) {
            // 获取原始文件的名称
            String originalFilename = new File(headerImg.getOriginalFilename()).getName();
            // 执行文件的上传的操作
            headerImg.transferTo(new File(uploadDirectory, originalFilename));
        }

        // 多文件上传
        if (photos != null) {
            for (MultipartFile photo : photos) {
                if (photo != null && !photo.isEmpty()) {
                    String originalFilename = new File(photo.getOriginalFilename()).getName();
                    photo.transferTo(new File(uploadDirectory, originalFilename));
                }
            }
        }
        return "main";
    }
}
