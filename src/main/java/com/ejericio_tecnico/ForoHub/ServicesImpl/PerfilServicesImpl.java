package com.ejericio_tecnico.ForoHub.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Entity.Perfil;
import com.ejericio_tecnico.ForoHub.Repository.IPerfilRepository;
import com.ejericio_tecnico.ForoHub.Services.IPerfilServices;

@Service
public class PerfilServicesImpl implements IPerfilServices{

	private IPerfilRepository perfilRepository;
	
	private PerfilServicesImpl(IPerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	@Override
	public Perfil createPerfil(Perfil newPerfil) {
		return perfilRepository.save(newPerfil);
	}

	@Override
	public List<Perfil> AllPerfil() {
		return perfilRepository.findAll();
	}

	@Override
	public Perfil findByIdPerfil(Long idPerfil) {
		return perfilRepository.findById(idPerfil).orElse(null);
	}

	@Override
	public Perfil updatefindByIdPerfil(Long idPerfil, Perfil updatePerfil) {
		 return perfilRepository.findById(idPerfil).map(perfil -> {
	            perfil.setNombre(updatePerfil.getNombre());
	            return perfilRepository.save(perfil);
	        }).orElse(null);
	}
	
    @Override
    public boolean eliminarPerfil(Long idPerfil) {
        return perfilRepository.findById(idPerfil).map(perfil -> {
            perfilRepository.delete(perfil);
            return true;
        }).orElse(false);
    }
}
