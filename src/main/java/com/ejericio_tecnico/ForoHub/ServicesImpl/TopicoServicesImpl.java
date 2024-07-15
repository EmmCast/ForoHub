package com.ejericio_tecnico.ForoHub.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Entity.Topico;
import com.ejericio_tecnico.ForoHub.Repository.ITopicoRepository;
import com.ejericio_tecnico.ForoHub.Services.ITopicoServieces;

@Service
public class TopicoServicesImpl implements ITopicoServieces{

	private ITopicoRepository topicoRepository;
	
	private TopicoServicesImpl(ITopicoRepository topicoRepository) {
		this.topicoRepository = topicoRepository;
	}

	@Override
	public Topico createTopico(Topico newTopico) {
        return topicoRepository.save(newTopico);

	}

	@Override
	public List<Topico> AllTopico() {
        return topicoRepository.findAll();
	}

	@Override
	public Topico findByIdTopico(Long idTopico) {
        return topicoRepository.findById(idTopico).orElse(null);
	}

	@Override
	public Topico updatefindByIdTopico(Long idTopico, Topico updateTopico) {
		return topicoRepository.findById(idTopico).map(topico -> {
            topico.setTitulo(updateTopico.getTitulo());
            topico.setMensaje(updateTopico.getMensaje());
            topico.setStatus(updateTopico.getStatus());
            topico.setUsuarioId(updateTopico.getUsuarioId());
            topico.setCursoId(updateTopico.getCursoId());
            return topicoRepository.save(topico);
        }).orElse(null);
	}
	
    @Override
    public boolean eliminarTopico(Long idTopico) {
        return topicoRepository.findById(idTopico).map(topico -> {
            topicoRepository.delete(topico);
            return true;
        }).orElse(false);
    }
	
}
