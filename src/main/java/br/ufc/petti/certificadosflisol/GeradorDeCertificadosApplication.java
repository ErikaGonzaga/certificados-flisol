package br.ufc.petti.certificadosflisol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GeradorDeCertificadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorDeCertificadosApplication.class, args);
	}
}
