package com.ejericio_tecnico.ForoHub.Services;

import java.util.List;

import com.ejericio_tecnico.ForoHub.Dto.CrearUsuario;
import com.ejericio_tecnico.ForoHub.Entity.Usuario;

public interface IUsuarioServices {

	public Usuario createUsuario(CrearUsuario newUsuario);
	public List<Usuario> AllUsuario();
	public Usuario findByIdUsuario(Long idUsuario);
	public Usuario updatefindByIdUsuario(Long idUsuario, Usuario updateUsuario);
	boolean eliminarUsuario(Long idUsuario);
}
