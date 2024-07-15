package com.ejericio_tecnico.ForoHub.Services;

import java.util.List;

import com.ejericio_tecnico.ForoHub.Entity.Topico;

public interface ITopicoServieces {
	
	public Topico createTopico(Topico newTopico);
	public List<Topico> AllTopico();
	public Topico findByIdTopico(Long idTopico);
	public Topico updatefindByIdTopico(Long idTopico, Topico updateTopico);
	boolean eliminarTopico(Long idTopico);
}
