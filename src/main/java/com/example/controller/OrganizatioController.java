package com.example.controller;

import com.example.entity.Organization;
import com.example.service.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class OrganizatioController {

    private final OrganizationService organizationService;

    public OrganizatioController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    public String companiesPage(Model model){
        model.addAttribute("organizations",organizationService.getAllorganizations());
        return "/organizations";
    }

    @GetMapping("/organization/ban/{id}")
    public String banOrganization(@PathVariable Long id,
                                  Model model){
        Organization organization=organizationService.getorganizationById(id);
        organization.setBanned(true);
        organizationService.saveorganization(organization);


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
    public String saveOrganization(@Valid @ModelAttribute("organization") Organization organization
                                  ,BindingResult bindingResult, @RequestParam("org_image") MultipartFile multipartFile ) throws IOException {

        if (bindingResult.hasErrors()) return "/create_organization";

        if (multipartFile.isEmpty()) {
            organizationService.saveorganization(organization);

        }
        else {
            String file_name = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            organization.setOrgImage(file_name);
            String uploadDir = "org_images/" + organizationService.saveorganization(organization).getId();
            organizationService.saveOrgFile(uploadDir, file_name, multipartFile);
        }
        return "redirect:/organizations";
    }
    @GetMapping("/test")
    public  String test(){
        return "/aaa";
    }
}
