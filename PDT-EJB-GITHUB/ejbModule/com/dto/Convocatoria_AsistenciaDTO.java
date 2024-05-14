package com.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.entities.Estudiante;
import com.entities.Evento;
import com.enums.EstadoEstudiante;
import com.enums.TipoAsistencia;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Convocatoria_AsistenciaDTO implements Serializable {
	
	private long idConvocatoria_Ast;

	private float calificacion;

	private TipoAsistencia tipoAsistencia;

	private Evento evento;

	private Estudiante estudiante;

}
