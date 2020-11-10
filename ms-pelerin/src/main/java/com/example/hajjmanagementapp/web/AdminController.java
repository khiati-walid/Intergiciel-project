package com.example.hajjmanagementapp.web;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.hajjmanagementapp.dao.MedecinRepository;
import com.example.hajjmanagementapp.entities.Medecin;
import com.example.hajjmanagementapp.sec.SecurityParams;
import com.example.hajjmanagementapp.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RestController
public class AdminController {


    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    MedecinService medecinService;


    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AdminController(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/add-Medecin")
    public Medecin addMedecin(@RequestBody Map<String,Object> payload){

        Medecin medecinOrdi= medecinService.saveMedecin(
                payload.get("username").toString(),
                payload.get("Residence").toString(),
                payload.get("password").toString()
        );
        return  medecinOrdi;
    }

    @PostMapping("/login-medecin")

    public void loginMedecin(@RequestBody Map<String,Object> payload,HttpServletRequest request,HttpServletResponse response){
        String username = payload.get("username").toString();

        String password = payload.get("password").toString();



        for(Medecin medecin : medecinRepository.findAll()){
            //  System.out.println(bCryptPasswordEncoder.matches(password,medecin.getPassword()));
            if (medecin.getUsername().equals(username) && bCryptPasswordEncoder.matches(password,medecin.getPassword())){
                System.out.println("*************************** ");
                String jwt = JWT.create()
                        .withIssuer(request.getRequestURI())
                        .withSubject(medecin.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                        .sign(Algorithm.HMAC256(SecurityParams.SECRET));
                System.out.println(jwt);
                response.addHeader(SecurityParams.JWT_HEADER_NAME, jwt);
            }
        }


    }
}
