package br.ufc.petti.certificadosflisol.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.petti.certificadosflisol.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByEmail(String email);
}
