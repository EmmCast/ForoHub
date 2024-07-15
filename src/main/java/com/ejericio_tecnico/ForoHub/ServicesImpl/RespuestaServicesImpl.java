package com.ejericio_tecnico.ForoHub.ServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejericio_tecnico.ForoHub.Entity.Respuesta;
import com.ejericio_tecnico.ForoHub.Repository.IRespuestaRepository;
import com.ejericio_tecnico.ForoHub.Services.IRespuestaServices;

@Service
public class RespuestaServicesImpl implements IRespuestaServices{

	private IRespuestaRepository respuestaRepository;
	
	private RespuestaServicesImpl(IRespuestaRepository respuestaRepository) {
		this.respuestaRepository = respuestaRepository;
	}

	@Override
	public Respuesta createRespuesta(Respuesta newRespuesta) {
		return respuestaRepository.save(newRespuesta);
	}

	@Override
	public List<Respuesta> AllRespuesta() {
		return respuestaRepository.findAll();
	}

	@Override
	public Respuesta findByIdRespuesta(Long idRespuesta) {
        return respuestaRepository.findById(idRespuesta).orElse(null);
	}

	@Override
	public Respuesta updatefindByIdRespuesta(Long idRespuesta, Respuesta updateRespuesta) {
		 return respuestaRepository.findById(idRespuesta).map(respuesta -> {
	            respuesta.setMensaje(updateRespuesta.getMensaje());
	            respuesta.setSolucion(updateRespuesta.getSolucion());
	            respuesta.setUsuarioId(updateRespuesta.getUsuarioId());
	            return respuestaRepository.save(respuesta);
	        }).orElse(null);
	    }

	    @Override
	    public boolean eliminarRespuesta(Long idRespuesta) {
	        return respuestaRepository.findById(idRespuesta).map(respuesta -> {
	            respuestaRepository.delete(respuesta);
	            return true;
	        }).orElse(false);
	    }
}
