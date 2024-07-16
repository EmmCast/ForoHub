package com.ejericio_tecnico.ForoHub.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Dto.CrearUsuario;
import com.ejericio_tecnico.ForoHub.Entity.Usuario;
import com.ejericio_tecnico.ForoHub.Repository.IUsuarioRepository;
import com.ejericio_tecnico.ForoHub.Services.IPerfilServices;
import com.ejericio_tecnico.ForoHub.Services.IUsuarioServices;

@Service
public class UsuarioServicesImpl implements IUsuarioServices{

	private IUsuarioRepository usuarioRepository;
	private IPerfilServices perfilServices;
	
	public UsuarioServicesImpl(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario createUsuario(CrearUsuario newUsuario) {
		Usuario usuario = new Usuario();
		usuario.getIdUsuario();
		usuario.setNombre(newUsuario.getNombre());
		usuario.setEmail(newUsuario.getEmail());
		usuario.setPassword(newUsuario.getPassword());
		usuario.setPerfilId(perfilServices.findByIdPerfil(newUsuario.getPerfilId()));
		
		
		 return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> AllUsuario() {
        return usuarioRepository.findAll();

	}

	@Override
	public Usuario findByIdUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario updatefindByIdUsuario(Long idUsuario, Usuario updateUsuario) {
		 return usuarioRepository.findById(idUsuario).map(usuario -> {
	            usuario.setNombre(updateUsuario.getNombre());
	            usuario.setEmail(updateUsuario.getEmail());
	            usuario.setPassword(updateUsuario.getPassword());
	            usuario.setPerfilId(perfilServices.findByIdPerfil(updateUsuario.getPerfilId().getIdPerfil()));
	            return usuarioRepository.save(usuario);
	        }).orElse(null);
	}
	
	   @Override
	    public boolean eliminarUsuario(Long idUsuario) {
	        return usuarioRepository.findById(idUsuario).map(usuario -> {
	            usuarioRepository.delete(usuario);
	            return true;
	        }).orElse(false);
	    }
}
