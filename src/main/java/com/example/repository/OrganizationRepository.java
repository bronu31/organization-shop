package com.example.repository;

import com.example.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    //List<String> findBy

    Organization findByOrgName(String org_name);
}
