package com.example.hajjmanagementapp.web;


import com.example.hajjmanagementapp.dao.MedicalRevRepository;
import com.example.hajjmanagementapp.dao.ParticipantRepository;
import com.example.hajjmanagementapp.entities.Medecin;
import com.example.hajjmanagementapp.entities.MedicalRev;
import com.example.hajjmanagementapp.entities.Participant;
import com.example.hajjmanagementapp.service.MedicalRevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MedecinController {

    @Autowired
    MedicalRevService medicalRevService;

    @Autowired
    MedicalRevRepository medicalRevRepository;

    @Autowired
    ParticipantRepository participantRepository;


    @PostMapping("/add-medicalRev")
    public MedicalRev addMedicalRev(@RequestBody Map<String,Object> payload) {

        MedicalRev medicalRevOrdi=  medicalRevService.saveMedicalRev(Integer.parseInt(payload.get("eye").toString()),
                Boolean.parseBoolean(payload.get("Vacacyw").toString()),
                Boolean.parseBoolean(payload.get("Vacrage").toString()),
                Boolean.parseBoolean(payload.get("VacHepatiteA").toString()),
                Boolean.parseBoolean(payload.get("VacHepatiteB").toString()),
                Boolean.parseBoolean(payload.get("booldPressure").toString()),
                Boolean.parseBoolean(payload.get("Heart").toString()),
                Boolean.parseBoolean(payload.get("Lungs").toString()),
                Boolean.parseBoolean(payload.get("pregnancyTest").toString()),
                Boolean.parseBoolean(payload.get("Sugar").toString()),
                payload.get("Avis").toString(),
                Long.parseLong(payload.get("idParticipant").toString())






        );

        medicalRevRepository.save(medicalRevOrdi);

        return medicalRevOrdi;

    }






    @GetMapping("/pelerinMed/{id}")
    public MedicalRev getMedicalRevWithParticipant(@PathVariable("id") Long ide)
    {
        MedicalRev medicalRev=medicalRevRepository.findById(ide).get();

        Participant participant= participantRepository.findParticipantById(medicalRev.getIdParticipant());

        medicalRev.setParticipant(participant);

        return  medicalRev;
    }
}
