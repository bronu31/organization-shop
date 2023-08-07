package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "organization")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq")
    private Long id;

    private String orgName;

    private String orgDescription;
@JsonIgnore
    private String orgImage;

    @Transient
    public String getOrgImage(){
        if(orgImage ==null||id==null) return null;
        return "/org_images/"+id+"/"+ orgImage;
    }

    //private List<Integer> org_product;

    private Boolean banned;

    public Organization(Long id, String OrgName,
                        String OrgDescription, String OrgImage) {
        this.id = id;
        this.orgName = OrgName;
        this.orgDescription = OrgDescription;
        this.orgImage = OrgImage;
        //this.org_product = new ArrayList<>();
        this.banned=false;
    }

    public Organization(Long id, String OrgName,
                        String OrgDescription) {
        this.id = id;
        this.orgName = OrgName;
        this.orgDescription = OrgDescription;
        //this.org_product = new ArrayList<>();
        this.banned=false;
    }



}
