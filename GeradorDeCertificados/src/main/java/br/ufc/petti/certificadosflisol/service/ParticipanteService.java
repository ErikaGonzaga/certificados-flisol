package br.ufc.petti.certificadosflisol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.petti.certificadosflisol.model.Participante;
import br.ufc.petti.certificadosflisol.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public List<Participante> listByEmail(String email){
		return participanteRepository.findByEmail(email); 
	}
	
	public Participante findById(Long id){
		return participanteRepository.findOne(id);
	}
	public void save(Participante participante) {
		participanteRepository.save(participante);
	}
}
