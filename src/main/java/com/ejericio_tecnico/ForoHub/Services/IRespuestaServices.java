package com.ejericio_tecnico.ForoHub.Services;

import java.util.List;

import com.ejericio_tecnico.ForoHub.Entity.Respuesta;

public interface IRespuestaServices {

	public Respuesta createRespuesta(Respuesta newRespuesta);
	public List<Respuesta> AllRespuesta();
	public Respuesta findByIdRespuesta(Long idRespuesta);
	public Respuesta updatefindByIdRespuesta(Long idRespuesta, Respuesta updateRespuesta);
	boolean eliminarRespuesta(Long idRespuesta);
}
