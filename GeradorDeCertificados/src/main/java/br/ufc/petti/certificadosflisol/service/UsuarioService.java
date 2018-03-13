package br.ufc.petti.certificadosflisol.service;

import org.springframework.stereotype.Service;

import br.ufc.petti.certificadosflisol.model.Usuario;

@Service
public interface UsuarioService{
	public Usuario findUsuarioByEmail(String email);
	public void saveUsuario(Usuario usuario);
	
	
}
