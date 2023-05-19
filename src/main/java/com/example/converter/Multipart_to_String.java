package com.example.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

public class Multipart_to_String implements Converter<MultipartFile,String> {
    @Override
    public String convert(MultipartFile source) {
        return source.getOriginalFilename();
    }
}
