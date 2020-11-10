package com.example.gestionvol.dao;

import com.example.gestionvol.entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface VolRepository extends JpaRepository<Vol,Long> {


}
