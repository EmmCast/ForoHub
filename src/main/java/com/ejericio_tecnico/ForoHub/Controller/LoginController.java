package com.ejericio_tecnico.ForoHub.Controller;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejericio_tecnico.ForoHub.Dto.DatosAutenticacion;
import com.ejericio_tecnico.ForoHub.Dto.DatosJWTToken;
import com.ejericio_tecnico.ForoHub.Entity.Usuario;
import com.ejericio_tecnico.ForoHub.Security.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutenticacion datosAutenticacionUsuario){
		Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.getEmail(),
                datosAutenticacionUsuario.getPassword());
		var usuarioAutenticado = authenticationManager.authenticate(authToken);
		var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
	}

}
