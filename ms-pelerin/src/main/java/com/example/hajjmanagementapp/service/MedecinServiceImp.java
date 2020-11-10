package com.example.hajjmanagementapp.service;


import com.example.hajjmanagementapp.dao.AppRoleRepository;
import com.example.hajjmanagementapp.dao.MedecinRepository;
import com.example.hajjmanagementapp.dao.ParticipantRepository;
import com.example.hajjmanagementapp.entities.AppRole;
import com.example.hajjmanagementapp.entities.Medecin;
import com.example.hajjmanagementapp.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class MedecinServiceImp implements MedecinService{


    @Autowired
    MedecinRepository medecinRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public MedecinServiceImp(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public Medecin saveMedecin(String username, String Residence, String password) {


        Medecin medecin = new Medecin();
        medecin.setUsername(username);
        medecin.setResidence(Residence);
        medecin.setPassword(bCryptPasswordEncoder.encode(password));

        medecinRepository.save(medecin);
        return medecin;
    }


}
