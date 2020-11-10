package com.example.hajjmanagementapp;

import com.example.hajjmanagementapp.dao.AppRoleRepository;
import com.example.hajjmanagementapp.entities.AppRole;
import com.example.hajjmanagementapp.entities.Participant;
import com.example.hajjmanagementapp.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;




@EnableFeignClients
@SpringBootApplication
public class HajjManagementAppApplication implements RepositoryRestConfigurer,CommandLineRunner {


    @Bean
    BCryptPasswordEncoder getBCPE(){
        return  new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(HajjManagementAppApplication.class, args);
    }

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private ParticipantService participantService;

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Participant.class,AppRole.class);

        if(appRoleRepository.count()==0)
        {
            participantService.saveRole(new AppRole(null,"PARTICIPANT"));
            participantService.saveRole(new AppRole(null,"ADMIN"));

        }

    }
}
