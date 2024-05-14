package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoConstancia;
import com.enums.TipoConstancia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Constancia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genConstancia", sequenceName = "SEQ_ID_CONSTANCIA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genConstancia")
	private long idConstancia;

	@Column(nullable = false, length = 30)
	private Date fechaHoraConstancia;
	
	@Column(nullable = false, length = 30)
	private String Detalle;

	@Enumerated
	@Column(nullable = false)
	private TipoConstancia tipoConstancia;
	
	@Enumerated
	@Column(nullable = false)
	private EstadoConstancia estadoConstancia;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Estudiante estudiante;
}
