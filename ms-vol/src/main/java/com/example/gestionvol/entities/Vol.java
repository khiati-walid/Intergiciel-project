package com.example.gestionvol.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDepart;

    private Date dateArrive;

    private String villeDepart;

    private String villeArrive;

    private Long prix;

    private Integer nbPlaceReserve;


    @ManyToOne
    private Avion avion;

    @ManyToOne
    private Compagnie compagnie;


}
