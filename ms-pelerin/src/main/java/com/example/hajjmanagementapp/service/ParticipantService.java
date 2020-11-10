package com.example.hajjmanagementapp.service;

import com.example.hajjmanagementapp.entities.AppRole;
import com.example.hajjmanagementapp.entities.Participant;

import java.util.Date;

public interface ParticipantService {


    Participant saveParticipant(Long numPassport,String username,String firstName,String familyName,String email,String numPhone,String Residence,Integer nbInscription,String genre

    ,String password, String confPass,Long IdVol);


    public AppRole saveRole(AppRole role);

    public Participant loadParticipantByEmail(String email);



    public  void addRoleToUser(String username, String rolename);



}
