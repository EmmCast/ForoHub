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

import com.ejericio_tecnico.ForoHub.Dto.CrearUsuario;
import com.ejericio_tecnico.ForoHub.Entity.Usuario;
import com.ejericio_tecnico.ForoHub.Services.IUsuarioServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioServices usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.AllUsuario();
    }

    @PostMapping
    public Usuario crearUsuario(@Valid @RequestBody CrearUsuario newUsuario) {
        return usuarioService.createUsuario(newUsuario);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long idUsuario, @Valid @RequestBody Usuario updateUsuario) {
        Usuario usuario = usuarioService.updatefindByIdUsuario(idUsuario, updateUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario) {
        if (usuarioService.eliminarUsuario(idUsuario)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}