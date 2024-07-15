package com.ejericio_tecnico.ForoHub.Services;

import java.util.List;

import com.ejericio_tecnico.ForoHub.Entity.Curso;

public interface ICursoServuces {

	public Curso createCurso(Curso newCurso);
	public List<Curso> AllCursos();
	public Curso findByIdCurso(Long idCurso);
	public Curso updatefindByIdCurso(Long idCurso, Curso updateCurso);
	boolean eliminarCurso(Long idCurso);
}
