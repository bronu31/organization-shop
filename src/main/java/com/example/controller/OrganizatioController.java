package com.example.controller;

import com.example.entity.Organization;
import com.example.entity.Student;
import com.example.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class OrganizatioController {

    private OrganizationService organizationService;

    public OrganizatioController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    public String companiesPage(Model model){
        System.out.println(model.addAttribute("organizations",organizationService.getAllorganizations()));
        model.addAttribute("organizations",organizationService.getAllorganizations());
        return "/organizations";
    }

    @GetMapping("/organization/ban/{id}")
    public String banOrganization(@PathVariable Long id,
                                  Model model){
        Organization organization=organizationService.getorganizationById(id);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(organization.toString());
        organization.setBanned(true);
        organizationService.saveorganization(organization);


        organizationService.getorganizationById(id).toString();
        return "redirect:/organizations";
    }

    @GetMapping("/organization/unban/{id}")
    public String unbanOrganization(@PathVariable  Long id,
                                    Model model){
        Organization organization=organizationService.getorganizationById(id);
        organization.setBanned(false);
        organizationService.saveorganization(organization);


        organizationService.getorganizationById(id).toString();
        return "redirect:/organizations";
    }
    @GetMapping("/organization/new")
    public String createOrganization(Model model){
        Organization organization= new Organization();
        model.addAttribute("organization",organization);
        return "/create_organization";
    }

    @PostMapping("/organizations")
    public String saveOrganization(@ModelAttribute("organization") Organization organization
                                  ,@RequestParam("org_image") MultipartFile multipartFile) throws IOException {

        String file_name= StringUtils.cleanPath(multipartFile.getOriginalFilename());
        organization.setOrg_image(file_name);



        Organization temp=organizationService.saveorganization(organization);
        String uploadDir = "org_images/" + temp.getId();
        organizationService.saveOrgFile(uploadDir,file_name,multipartFile);

        organizationService.saveorganization(organization);
        return "redirect:/organizations";
    }
}
