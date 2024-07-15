package com.ejericio_tecnico.ForoHub.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Entity.Curso;
import com.ejericio_tecnico.ForoHub.Repository.ICursoRepository;
import com.ejericio_tecnico.ForoHub.Services.ICursoServuces;

@Service
public class CursoServicesImpl implements ICursoServuces{

	public ICursoRepository cursoRepository;
	
	public CursoServicesImpl(ICursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	public Curso createCurso(Curso newCurso) {
		return cursoRepository.save(newCurso);
	}

	@Override
	public List<Curso> AllCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso findByIdCurso(Long idCurso) {
		return cursoRepository.findById(idCurso).orElse(null);
	}

	@Override
	public Curso updatefindByIdCurso(Long idCurso, Curso updateCurso) {
		return cursoRepository.findById(idCurso).map(curso -> {
            curso.setNombre(updateCurso.getNombre());
            curso.setCategoria(updateCurso.getCategoria());
            return cursoRepository.save(curso);
        }).orElse(null);
	}
	
	   @Override
	    public boolean eliminarCurso(Long idCurso) {
	        return cursoRepository.findById(idCurso).map(curso -> {
	            cursoRepository.delete(curso);
	            return true;
	        }).orElse(false);
	    }
}
