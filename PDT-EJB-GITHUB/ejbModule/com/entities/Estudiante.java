package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoEstudiante;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Estudiante extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated
	@Column(nullable = true)
	private EstadoEstudiante estadoEstudiante;

	@Column(nullable = false, length = 30)
	private String añoIngreso;

}
