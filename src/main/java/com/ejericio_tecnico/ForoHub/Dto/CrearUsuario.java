package com.ejericio_tecnico.ForoHub.Dto;

import lombok.Data;

@Data
public class CrearUsuario {

	private String nombre;
	private String email;
	private String password;
	private Long perfilId;
}
