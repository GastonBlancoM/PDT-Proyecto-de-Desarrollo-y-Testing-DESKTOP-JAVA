package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoJustificacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Justificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genJustificacion", sequenceName = "SEQ_ID_JUSTIFICACION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genJustificacion")
	private long idJustificacion;

	@Column(nullable = true, length = 200)
	private String Detalle;

	@Column(nullable = true, length = 30)
	private Date FechaHoraJustificacion;

	@Enumerated
	@Column(nullable = true)
	private EstadoJustificacion estadoJustificacion;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Estudiante estudiante;

}
