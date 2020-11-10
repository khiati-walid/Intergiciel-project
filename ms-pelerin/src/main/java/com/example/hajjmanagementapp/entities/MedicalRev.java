package com.example.hajjmanagementapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer eye;

    private boolean Vacacyw=false;

    private boolean Vacrage=false;

    private boolean VacHepatiteA=false;

    private boolean VacHepatiteB=false;

    private boolean BooldPressure=false;

    private boolean Heart=false;

    private boolean Lungs=false;

    private boolean pregnancyTest=false;

    private boolean Sugar=false;

    private String Avis;

    private Long idParticipant;

    @OneToOne
    private Participant participant;

    @ManyToOne
    private Medecin medecin;





}
