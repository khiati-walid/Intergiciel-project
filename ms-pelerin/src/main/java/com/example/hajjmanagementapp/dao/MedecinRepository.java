package com.example.hajjmanagementapp.dao;

import com.example.hajjmanagementapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MedecinRepository extends JpaRepository<Medecin, Long> {


}
