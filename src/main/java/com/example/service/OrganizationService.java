package com.example.service;

import com.example.entity.Organization;
import com.example.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface OrganizationService {

    List<Organization> getAllorganizations();

    Organization saveorganization(Organization organization);

    Organization getorganizationById(Long id);
    Organization updateorganization(Organization organization);
    void deleteorganizationById(Long id);

    public void saveOrgFile(String uploadDir, String fileName,
                            MultipartFile multipartFile)  throws IOException;


}
