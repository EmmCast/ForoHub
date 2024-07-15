package com.ejericio_tecnico.ForoHub.Entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long idCurso;

	@NotBlank(message = "el nombre del curso no puede estar en blanco")
	@UniqueElements(message = "este elemento ya existe")
	@Column(name ="nombre")
	private String nombre;
	

	@NotBlank(message = "el nombre de la catagoria no puede estar en blanco")
	@Column(name ="categoria")
	private String categoria;
}
