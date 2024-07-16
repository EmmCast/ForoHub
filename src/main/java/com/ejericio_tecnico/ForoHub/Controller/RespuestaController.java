package com.ejericio_tecnico.ForoHub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejericio_tecnico.ForoHub.Entity.Respuesta;
import com.ejericio_tecnico.ForoHub.Services.IRespuestaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private IRespuestaServices respuestaService;

    @GetMapping
    public List<Respuesta> listarRespuestas() {
        return respuestaService.AllRespuesta();
    }

    @PostMapping
    public Respuesta crearRespuesta(@Valid @RequestBody Respuesta newRespuesta) {
        return respuestaService.createRespuesta(newRespuesta);
    }

    @GetMapping("/{idRespuesta}")
    public ResponseEntity<Respuesta> obtenerRespuestaPorId(@PathVariable Long idRespuesta) {
        Respuesta respuesta = respuestaService.findByIdRespuesta(idRespuesta);
        if (respuesta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{idRespuesta}")
    public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable Long idRespuesta, @Valid @RequestBody Respuesta updateRespuesta) {
        Respuesta respuesta = respuestaService.updatefindByIdRespuesta(idRespuesta, updateRespuesta);
        if (respuesta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{idRespuesta}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long idRespuesta) {
        if (respuestaService.eliminarRespuesta(idRespuesta)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}