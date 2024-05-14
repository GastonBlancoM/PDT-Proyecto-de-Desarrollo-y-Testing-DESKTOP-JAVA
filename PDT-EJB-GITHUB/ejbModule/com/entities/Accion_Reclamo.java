package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class Accion_Reclamo implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	@Id
	@SequenceGenerator(name = "genAcc_Rec", sequenceName = "SEQ_ID_ACC_REC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genAcc_Rec")
	private long idAcc_Rec;
	
	@Column(nullable = false, length = 100)
	private String detalle;

	@Column(nullable = false, length = 30)
	private Date FechaHora;
	

	@ManyToOne(optional=false)
	private Reclamo reclamo;


	@ManyToOne(optional=false)
	private Analista analista;
	} 
	
   

