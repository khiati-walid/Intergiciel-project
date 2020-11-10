package com.example.hajjmanagementapp.sec;

import com.example.hajjmanagementapp.dao.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }



    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers()
             ;}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/add-Participant/**","/pelerin/**","/pelerin/{id}"
        ).permitAll();

      http.authorizeRequests().antMatchers("/add-Medecin/**","/add-medicalRev","/login-medecin/**","/participants/**","/tirage/**","/filtrage/**").hasAuthority("ADMIN");


        http.authorizeRequests().anyRequest().authenticated();

        http.addFilter(new JWTAuthentificationFilter(authenticationManager(),participantRepository));
        http.addFilterBefore(new JWTAutorisationFilter(),UsernamePasswordAuthenticationFilter.class);
        
    }


}

