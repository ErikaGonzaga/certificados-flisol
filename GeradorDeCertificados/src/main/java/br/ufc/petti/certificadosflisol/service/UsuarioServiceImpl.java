package br.ufc.petti.certificadosflisol.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.petti.certificadosflisol.model.Role;
import br.ufc.petti.certificadosflisol.model.Usuario;
import br.ufc.petti.certificadosflisol.repository.RoleRepository;
import br.ufc.petti.certificadosflisol.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	@Override
	public Usuario findUsuarioByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        Role userRole = roleRepository.findByRole("ADMIN");
        usuario.setActive(1);
        usuario.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        usuarioRepository.save(usuario);
	}

}
