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

import com.ejericio_tecnico.ForoHub.Entity.Curso;
import com.ejericio_tecnico.ForoHub.Services.ICursoServuces;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICursoServuces cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.AllCursos();
    }

    @PostMapping
    public Curso crearCurso(@Valid @RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long idCurso) {
        Curso curso = cursoService.findByIdCurso(idCurso);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long idCurso, @Valid @RequestBody Curso detallesCurso) {
        Curso curso = cursoService.updatefindByIdCurso(idCurso, detallesCurso);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long idCurso) {
        if (cursoService.eliminarCurso(idCurso)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}