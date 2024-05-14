package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.enums.TipoAsistencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Convocatoria_Asistencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genCon_Ast", sequenceName = "SEQ_ID_CON_AST", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genCon_Ast")
	private long idConvocatoria_Ast;

	@Column(nullable = true, length = 30)
	private float calificacion;

	@Enumerated
	@Column(nullable = true)
	private TipoAsistencia tipoAsistencia;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Estudiante estudiante;
}
