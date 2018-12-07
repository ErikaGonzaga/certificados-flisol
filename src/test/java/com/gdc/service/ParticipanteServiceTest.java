package com.gdc.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufc.petti.certificadosflisol.GeradorDeCertificadosApplication;

import br.ufc.petti.certificadosflisol.model.Participante;
import br.ufc.petti.certificadosflisol.repository.ParticipanteRepository;
import br.ufc.petti.certificadosflisol.service.ParticipanteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeradorDeCertificadosApplication.class)
public class ParticipanteServiceTest {

	@Autowired
	@InjectMocks
	private ParticipanteService partServ;
	
	@MockBean
	private ParticipanteRepository partRep;
	
	private ArrayList<Participante> participantes;
	
	@Test
	public void verificaListByEmail() {
		participantes = new ArrayList<>();
		participantes.add(new Participante(0,"Igor", "igor@gmail.com"));
		participantes.add(new Participante(1,"Erika", "erika@gmail.com"));
		participantes.add(new Participante(2,"Cezar", "cezar@gmail.com"));
		partRep.findAll();
		
		Mockito.when(partRep.findOne(2)).thenReturn(participantes.get(2));
		assertThat(partServ.findById(2)).isEqualTo(participantes.get(2));
	}
}
