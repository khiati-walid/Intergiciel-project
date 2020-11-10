package com.example.hajjmanagementapp.dao;

import com.example.hajjmanagementapp.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface ParticipantRepository extends JpaRepository<Participant, Long> {




    Participant findParticipantByUsername(String username);

    public Participant findByEmailIgnoreCase(String email);

    Participant findByNumPassport(Long numPass);

    Participant findParticipantById(Long id);


    @Query(value = "SELECT * FROM participant ORDER BY RAND() LIMIT :nb",nativeQuery = true)
    List<Participant> getRandomParticipants(@Param("nb") int nb);

    @Query(value = "SELECT * FROM participant p where p.is_pelerin=0  LIMIT :nb",nativeQuery = true)
    List<Participant> getPortionParticipant(@Param("nb") int nb);
}
