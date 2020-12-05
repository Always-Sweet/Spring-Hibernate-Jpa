package com.demo.controller;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件controller
 * 用于上传书籍封面
 */
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 文件上传
     *
     * @param file
     */
    @PostMapping
    public void fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String path = ClassUtils.getDefaultClassLoader().getResource("\\").toURI().getPath();
            path = path.substring(0, path.lastIndexOf("/WEB-INF/classes"));
            OutputStream os = new FileOutputStream(path + "/image/" + file.getOriginalFilename());
            InputStream is  = file.getInputStream();
            int temp;
            while((temp = is .read()) != -1) {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
