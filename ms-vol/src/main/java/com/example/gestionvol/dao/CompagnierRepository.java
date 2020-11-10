package com.example.gestionvol.dao;


import com.example.gestionvol.entities.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;





@RepositoryRestResource
public interface CompagnierRepository extends JpaRepository<Compagnie, Long> {
}
