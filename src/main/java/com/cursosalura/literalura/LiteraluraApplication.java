package com.cursosalura.literalura;

import com.cursosalura.literalura.principal.Principal;
import com.cursosalura.literalura.repository.autorRepository;
import com.cursosalura.literalura.repository.libroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private autorRepository autorRepository;

	@Autowired
	private libroRepository libroRepository;


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception {
		Principal principal = new Principal(autorRepository, libroRepository);
		principal.muestraElMenu();

	}

}
