package com.example.hajjmanagementapp.sec;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;;
import com.example.hajjmanagementapp.dao.ParticipantRepository;
import com.example.hajjmanagementapp.entities.Participant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

   //pour verifier le token

    private ParticipantRepository participantRepository;
    private AuthenticationManager authenticationManager;

    public JWTAuthentificationFilter(AuthenticationManager authenticationManager,ParticipantRepository participantRepository) {
        this.authenticationManager = authenticationManager;
        this.participantRepository=participantRepository;

    }

    public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
    {
        Participant participant = null;
        try {
                participant = new ObjectMapper().readValue(request.getInputStream(), Participant.class);
                return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(participant.getEmail(), participant.getPassword()));
              } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Pb in request content");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach(a -> {
            roles.add(a.getAuthority());
        });
        Participant appUser=participantRepository.findByEmailIgnoreCase(user.getUsername());

            String jwt = JWT.create()
                    .withIssuer(request.getRequestURI())
                    .withSubject(appUser.getEmail())
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("IDUSER",appUser.getId())
                    .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                    .sign(Algorithm.HMAC256(SecurityParams.SECRET));
            System.out.println(jwt);

            response.addHeader(SecurityParams.JWT_HEADER_NAME, jwt);

    }
}
