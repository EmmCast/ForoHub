package com.ejericio_tecnico.ForoHub.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topicos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico  implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_topico")
    private Long idTopico;

    @NotBlank(message = "el Titulo no puede estar en blanco")
	@Column(name ="titulo")
    private String titulo;

	@NotBlank(message = "el mensaje no puede estar en blanco")
	@Column(name ="mensaje")
    private String mensaje;

    @NotNull
	@Column(name ="fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

	@NotBlank(message = "el Status no puede estar en blanco")
	@Column(name ="status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id_usuario")
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "curso_id",referencedColumnName = "id_curso")
    private Curso cursoId;

}
