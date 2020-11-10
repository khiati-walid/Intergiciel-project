package com.example.hajjmanagementapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class AppRole {



   @javax.persistence.Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;



}
