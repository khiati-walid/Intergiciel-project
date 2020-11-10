package com.example.hajjmanagementapp.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String Residence;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;



    @OneToMany
    private Collection<MedicalRev> medicalRevs = new ArrayList<>();


}
