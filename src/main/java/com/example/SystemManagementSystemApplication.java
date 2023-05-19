package com.example;

import com.example.entity.Organization;
import com.example.entity.Student;
import com.example.repository.OrganizationRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemManagementSystemApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SystemManagementSystemApplication.class,args);


    }
    //@Autowired
   // private StudentRepository studentRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public void run(String... args) throws Exception {
        /*Organization student1= new Organization(1,"Фабрика","фабрика теста");

        organizationRepository.save(student1);
        Organization student2= new Organization(2,"Фермерство","фермерство имени ленина");

        organizationRepository.save(student2);*/
    }

}
