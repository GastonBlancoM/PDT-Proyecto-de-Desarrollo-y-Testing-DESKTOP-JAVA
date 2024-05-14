package com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.entities.Analista;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.Tutor;
import com.enums.EstadoEstudiante;
import com.enums.EstadoEvento;
import com.enums.Modalidad;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudianteDTO extends UsuarioDTO implements Serializable {

	private String añoIngreso;

	private EstadoEstudiante estadoEstudiante;

	private TipoUsuario tipoUsuario;

}
