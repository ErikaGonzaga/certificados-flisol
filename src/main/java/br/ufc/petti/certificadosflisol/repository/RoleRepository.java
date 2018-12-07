package br.ufc.petti.certificadosflisol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.petti.certificadosflisol.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findByRole(String role);
}
