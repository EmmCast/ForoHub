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

import com.ejericio_tecnico.ForoHub.Entity.Topico;
import com.ejericio_tecnico.ForoHub.Services.ITopicoServieces;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoServieces topicoService;

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoService.AllTopico();
    }

    @PostMapping
    public Topico crearTopico(@Valid @RequestBody Topico newTopico) {
        return topicoService.createTopico(newTopico);
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long idTopico) {
        Topico topico = topicoService.findByIdTopico(idTopico);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{idTopico}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long idTopico, @Valid @RequestBody Topico updateTopico) {
        Topico topico = topicoService.updatefindByIdTopico(idTopico, updateTopico);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{idTopico}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long idTopico) {
        if (topicoService.eliminarTopico(idTopico)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
