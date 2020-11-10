package com.example.hajjmanagementapp.entities;
import com.example.hajjmanagementapp.model.Vol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class  Participant {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long numPassport;

    @Column(unique = true)
    private String username;

    private String firstName;

    private String familyName;

    @Column(unique = true)
    private String email;

    private String numPhone;

    private String Residence;

    private Integer nbInscription;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private Genre genre;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDate birthDate;

    private int age;

    private boolean IsMahram=false;

    private boolean IsPelerin=false;

    private boolean IsTakenFirstStage=false;

    private boolean IsTakenSecondStage=false;

    private Long IdVol;

    @Transient
    private Vol vol;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<AppRole> roles = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "Mahram")
    private Participant participant;


    @OneToOne
    private MedicalRev medicalRev;

}
