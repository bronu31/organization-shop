package com.example.entity;


import lombok.*;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue
    private Long id;

    private String org_name;

    private String org_description;

    private String org_image;

    @Transient
    public String getOrg_image(){
        if(org_image==null||id==null) return null;
        return "/org_images/"+id+"/"+org_image;
    }

    //private List<Integer> org_product;

    private Boolean banned;

    public Organization(Long id, String org_name,
                        String org_description,String org_image) {
        this.id = id;
        this.org_name = org_name;
        this.org_description = org_description;
        this.org_image = org_image;
        //this.org_product = new ArrayList<>();
        this.banned=false;
    }

    public Organization(Long id, String org_name,
                        String org_description) {
        this.id = id;
        this.org_name = org_name;
        this.org_description = org_description;
        //this.org_product = new ArrayList<>();
        this.banned=false;
    }



}
