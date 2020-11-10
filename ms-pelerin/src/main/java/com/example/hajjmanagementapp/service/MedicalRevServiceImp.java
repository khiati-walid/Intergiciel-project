package com.example.hajjmanagementapp.service;


import com.example.hajjmanagementapp.dao.MedicalRevRepository;
import com.example.hajjmanagementapp.entities.MedicalRev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class MedicalRevServiceImp implements MedicalRevService {

@Autowired
    MedicalRevRepository medicalRevRepository;



    @Override
    public MedicalRev saveMedicalRev(Integer eye, boolean Vacacyw, boolean Vacrage, boolean VacHepatiteA, boolean VacHepatiteB,
                                     boolean booldPressure, boolean Heart, boolean Lungs,
                                     boolean pregnancyTest, boolean Sugar, String Avis,Long idParticipant) {


        MedicalRev medicalRev = new MedicalRev();

        medicalRev.setEye(eye);
        medicalRev.setVacacyw(Vacacyw);
        medicalRev.setVacrage(Vacrage);
        medicalRev.setVacHepatiteA(VacHepatiteA);
        medicalRev.setVacHepatiteB(VacHepatiteB);
        medicalRev.setBooldPressure(booldPressure);
        medicalRev.setHeart(Heart);
        medicalRev.setLungs(Lungs);
        medicalRev.setPregnancyTest(pregnancyTest);
        medicalRev.setSugar(Sugar);
        medicalRev.setAvis(Avis);
        medicalRev.setIdParticipant(idParticipant);


        medicalRevRepository.save(medicalRev);



        return medicalRev;
    }
}
