package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoReclamo;
import com.enums.TipoSemestre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reclamo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genReclamo", sequenceName = "SEQ_ID_RECLAMO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genReclamo")
	private long idReclamo;

	@Column(nullable = true, length = 30)
	private Date fechaHoraReclamo;

	@Column(nullable = true, length = 250)
	private String descripcion;

	@Enumerated
	@Column(nullable = true)
	private TipoSemestre tipoSemestre;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Estudiante estudiante;

	@Enumerated
	@Column(nullable = true)
	private EstadoReclamo estadoReclamo;

}
