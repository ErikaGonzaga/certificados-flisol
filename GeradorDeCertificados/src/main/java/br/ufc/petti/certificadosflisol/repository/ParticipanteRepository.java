package br.ufc.petti.certificadosflisol.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.petti.certificadosflisol.entity.Participante;

@Repository
@Transactional
public interface ParticipanteRepository extends JpaRepository<Participante, Long>{

	public List<Participante> findByEmail(String email);
	
}
