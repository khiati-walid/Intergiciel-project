package com.example.hajjmanagementapp.service;

import com.example.hajjmanagementapp.entities.MedicalRev;


public interface MedicalRevService {



    MedicalRev saveMedicalRev(Integer eye, boolean Vacacyw, boolean Vacrage, boolean VacHepatiteA, boolean VacHepatiteB,
                              boolean booldPressure, boolean Heart, boolean Lungs, boolean pregnancyTest,
                              boolean Sugar, String Avis,Long idParticipant);
}
