package br.ufc.petti.certificadosflisol.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.petti.certificadosflisol.model.Participante;

@Repository
@Transactional
public interface ParticipanteRepository extends JpaRepository<Participante, Integer>{

	
	public List<Participante> findByEmail(String email);
	
}
