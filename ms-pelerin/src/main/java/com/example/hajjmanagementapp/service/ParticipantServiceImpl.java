package com.example.hajjmanagementapp.service;

import com.example.hajjmanagementapp.dao.AppRoleRepository;
import com.example.hajjmanagementapp.dao.ParticipantRepository;
import com.example.hajjmanagementapp.entities.AppRole;
import com.example.hajjmanagementapp.entities.Genre;
import com.example.hajjmanagementapp.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;





@Service
public class ParticipantServiceImpl implements ParticipantService {



    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    public ParticipantServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public Participant saveParticipant(Long numPassport, String username, String firstName, String familyName, String email,
                                       String numPhone,String Residence,Integer nbInscription,String genre,
                                       String password, String confPass,Long IdVol) {

       Participant parti = participantRepository.findParticipantByUsername(username);

       if(parti!=null){
           throw new RuntimeException("Participant already exists");
       }

       if(!password.equals(confPass)) throw  new RuntimeException("Please Confirm your password");

       Participant participant = new Participant();
       participant.setNumPassport(numPassport);
       participant.setEmail(email); participant.setUsername(username);
       participant.setFirstName(firstName); participant.setFamilyName(familyName);
       participant.setResidence(Residence);
       participant.setNbInscription(nbInscription);
       participant.setGenre(Genre.valueOf(genre));

       participant.setNumPhone(numPhone);
       participant.setIdVol(IdVol);

        participant.setPassword(bCryptPasswordEncoder.encode(password));

        participantRepository.save(participant);


        addRoleToUser(username,"PARTICIPANT");

        return participant;
    }


    @Override
    public AppRole saveRole(AppRole role) {

        return appRoleRepository.save(role);
    }

    @Override
    public Participant loadParticipantByEmail(String email) {
        Participant user=participantRepository.findByEmailIgnoreCase(email);
        if(user==null) throw  new RuntimeException("We cannot find this participant");
        return user;
    }


    @Override
    public void addRoleToUser(String username, String rolename) {
        Participant participant = participantRepository.findParticipantByUsername(username);
        System.out.println(" Participant :..."+participant);
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        participant.getRoles().add(appRole);

    }
}
