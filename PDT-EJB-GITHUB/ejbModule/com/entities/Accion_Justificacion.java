package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACCION_JUSTIFICACION")

public class Accion_Justificacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genAcc_Jus", sequenceName = "SEQ_ID_ACC_JUS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genAcc_Jus")
	private long idAcc_Jus;

	@Column(nullable = false, length = 150)
	private String detalle;

	@Column(nullable = false, length = 30)
	private Date FechaHora;

	@ManyToOne(optional = false)
	private Analista analista;

	@ManyToOne(optional = false)
	private Justificacion justificacion;
}
