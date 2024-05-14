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
public class Solicitud implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genSolicitud", sequenceName = "SEQ_ID_SOLICITUD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSolicitud")
	private long idSolicitud;

	@Column(nullable = true, length = 30)
	private Date Fecha;

}