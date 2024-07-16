package com.ejericio_tecnico.ForoHub.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfiles")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private Long idPerfil;

	@NotBlank(message = "el nombre no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;
	
}
