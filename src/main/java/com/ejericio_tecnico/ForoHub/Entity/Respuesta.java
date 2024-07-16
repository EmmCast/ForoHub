package com.ejericio_tecnico.ForoHub.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "respuestas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
    private Long idRespuesta;

    @NotBlank(message = "el Mensaje no puede estar en blanco")
	@Column(name ="mensaje")
    private String mensaje;

    @NotNull
    @Column(name ="fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @NotNull
    @Column(name ="solucion")
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id_usuario")
    private Usuario usuarioId;

 /*   
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
*/
    
    
}
