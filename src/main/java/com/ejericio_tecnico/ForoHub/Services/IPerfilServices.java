package com.ejericio_tecnico.ForoHub.Services;

import java.util.List;

import com.ejericio_tecnico.ForoHub.Entity.Perfil;

public interface IPerfilServices {

	public Perfil createPerfil(Perfil newPerfil);
	public List<Perfil> AllPerfil();
	public Perfil findByIdPerfil(Long idPerfil);
	public Perfil updatefindByIdPerfil(Long idPerfil, Perfil updatePerfil);
	boolean eliminarPerfil(Long idPerfil);
	
}
