package com.example.hajjmanagementapp.sec;


import com.example.hajjmanagementapp.entities.Participant;
import com.example.hajjmanagementapp.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ParticipantService participantService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException ,RuntimeException{
        Participant participant=participantService.loadParticipantByEmail(email);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        participant.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        return new User(participant.getEmail(),participant.getPassword(),authorities);
    }
}
