package com.example.hajjmanagementapp.dao;

import com.example.hajjmanagementapp.entities.MedicalRev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MedicalRevRepository extends JpaRepository<MedicalRev,Long> {
}
