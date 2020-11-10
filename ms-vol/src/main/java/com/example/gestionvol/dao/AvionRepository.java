package com.example.gestionvol.dao;


import com.example.gestionvol.entities.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AvionRepository extends JpaRepository<Avion, Long> {
}
