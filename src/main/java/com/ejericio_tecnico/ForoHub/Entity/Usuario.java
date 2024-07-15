package com.ejericio_tecnico.ForoHub.Entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@NotBlank(message = "el nombre de usuario no puede estar en blanco")
	@UniqueElements(message = "este usuario ya existe")
	@Column(name ="nombre")
	private String nombre;
	

	@Email()
	@Column(name ="correoelectronico")
	private String correoelectronico;
	
	@Email()
	@NotBlank(message = "la contraseña no puede ser nula")
	@Size(min = 6,max = 50, message = "la contraseña no cumple los criterios")
	@Column(name ="contrasena")
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name = "perfil_id",referencedColumnName = "id_perfil")
	private Perfil perfilId;

}
