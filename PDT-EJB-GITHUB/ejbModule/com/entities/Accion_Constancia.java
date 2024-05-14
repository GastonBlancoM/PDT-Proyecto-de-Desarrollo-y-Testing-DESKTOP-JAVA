package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accion_Constancia implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	@Id
	@SequenceGenerator(name = "genAcc_Con", sequenceName = "SEQ_ID_ACC_CON", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genAcc_Con")
	private long idAcc_Con;
	
	@Column(nullable = false, length = 100)
	private String detalle;

	@Column(nullable = false, length = 30)
	private Date FechaHora;

	@ManyToOne(optional=false)
	private Constancia constancia;
	

	@ManyToOne(optional=false)
	private Analista analista;

	} 
