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

import com.ejericio_tecnico.ForoHub.Entity.Perfil;
import com.ejericio_tecnico.ForoHub.Services.IPerfilServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private IPerfilServices perfilService;

    @GetMapping
    public List<Perfil> listarPerfiles() {
        return perfilService.AllPerfil();
    }

    @PostMapping
    public Perfil crearPerfil(@Valid @RequestBody Perfil newPerfil) {
        return perfilService.createPerfil(newPerfil);
    }

    @GetMapping("/{idPerfil}")
    public ResponseEntity<Perfil> obtenerPerfilPorId(@PathVariable Long idPerfil) {
        Perfil perfil = perfilService.findByIdPerfil(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }

    @PutMapping("/{idPerfil}")
    public ResponseEntity<Perfil> actualizarPerfil(@PathVariable Long idPerfil, @Valid @RequestBody Perfil updatePerfil) {
        Perfil perfil = perfilService.updatefindByIdPerfil(idPerfil, updatePerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/{idPerfil}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable Long idPerfil) {
        if (perfilService.eliminarPerfil(idPerfil)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
