package com.gdc.model;

import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import br.ufc.petti.certificadosflisol.model.Participante;

public class ParticipanteTests {

	@Test
	public void verificarNomesDiferentesDeParticipante() {
		
		Participante participante1 = new Participante(0,"Erika","erika@gmail.com");
		Participante participante2 = new Participante(1,"Igor","igor@gmail.com");
		assertNotEquals(participante1.getNome(), participante2.getNome());
	}
	
	@Test
	public void verificarEmailsDiferentes() {
		Participante participante1 = new Participante(0,"Erika","erika@gmail.com");
		Participante participante2 = new Participante(1,"Igor","igor@gmail.com");
		assertNotEquals(participante1.getEmail(), participante2.getEmail());
	}
}
