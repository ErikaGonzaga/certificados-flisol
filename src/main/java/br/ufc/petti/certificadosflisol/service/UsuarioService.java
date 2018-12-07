package br.ufc.petti.certificadosflisol.service;

import org.springframework.stereotype.Service;

import br.ufc.petti.certificadosflisol.model.Usuario;

@Service
public interface UsuarioService{
	Usuario findUsuarioByEmail(String email);
	void saveUsuario(Usuario usuario);
	
	
}
