package com.ejericio_tecnico.ForoHub.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Entity.Usuario;
import com.ejericio_tecnico.ForoHub.Repository.IUsuarioRepository;
import com.ejericio_tecnico.ForoHub.Services.IUsuarioServices;

@Service
public class AutenticacionServivesImpl implements UserDetailsService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(email);
	}
	
	public void guardarUsuario(Usuario usuario) {
	    String contrasenaCodificada = passwordEncoder.encode(usuario.getPassword());
	    usuario.setPassword(contrasenaCodificada);
	    usuarioRepository.save(usuario);
	}
}
