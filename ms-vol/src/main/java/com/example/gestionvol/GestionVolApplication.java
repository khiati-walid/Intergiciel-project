package com.example.gestionvol;

import com.example.gestionvol.dao.AvionRepository;
import com.example.gestionvol.dao.CompagnierRepository;
import com.example.gestionvol.dao.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionVolApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionVolApplication.class, args);
	}

	@Autowired
	private VolRepository volRepository;


	@Autowired
	private AvionRepository avionRepository;

	@Autowired
	private CompagnierRepository compagnierRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
