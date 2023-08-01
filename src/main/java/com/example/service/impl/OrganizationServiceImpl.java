package com.example.service.impl;

import com.example.entity.Organization;
import com.example.entity.Student;
import com.example.repository.OrganizationRepository;
import com.example.repository.StudentRepository;
import com.example.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {

        this.organizationRepository = organizationRepository;
    }


    @Override
    public List<Organization> getAllorganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization saveorganization(Organization organization) {
        return organizationRepository.save(organization);
    }


    @Override
    public Organization getorganizationById(Long id) {
        return organizationRepository.getReferenceById(id);
    }

    @Override
    public Organization updateorganization(Organization organization) {
        return saveorganization(organization);
    }

    @Override
    public void deleteorganizationById(Long id) {
        organizationRepository.deleteById(id);
    }

    public void saveOrgFile(String uploadDir, String fileName,
                            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }


    }

    @Override
    public Organization getOrganizationByName(String name) {
        Organization organization= organizationRepository.findByOrgName(name);
        if (organization==null){
            throw new EntityNotFoundException("Organization not found");
        }
        return organization;
    }


}
