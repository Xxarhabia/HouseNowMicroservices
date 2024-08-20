package com.msara.post.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class DataUtils {

    public List<String> parseImageToBase64(List<MultipartFile> images) {
        try {
            List<String> listImagesBase64 = new ArrayList<>();
            for (MultipartFile image : images) {
                String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());
                listImagesBase64.add(imageBase64);
            }
            return listImagesBase64;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
