package com.example.controller.restcontroller;

import com.example.entity.Organization;
import com.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class OrganizationRestController {
@Autowired
    private final OrganizationService organizationService;

    public OrganizationRestController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(value = "rest/organization")
    public List<Organization> getOrganizations(){
        return organizationService.getAllorganizations();
    }

    @GetMapping(value = "rest/organization/{id}")
    @ResponseBody
    public Organization getOrganizations(@PathVariable Long id){
        System.out.println(organizationService.getorganizationById(id).toString());


        return organizationService.getorganizationById(id);


    }

}
