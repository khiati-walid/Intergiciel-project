package com.example.hajjmanagementapp.model;


import lombok.Data;

import java.util.Date;


@Data
public class Vol {
    private Long idVol;

    private Date dateDepart;

    private Date dateArrive;

    private String villeDepart;

    private String villeArrive;

    private Long prix;

    private Integer nbPlaceReserve;
}
