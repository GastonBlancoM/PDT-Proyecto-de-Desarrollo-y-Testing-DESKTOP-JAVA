package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoITR;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ITR implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genITR", sequenceName = "SEQ_ID_ITR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genITR")
	private long idITR;

	@Column(nullable = true, length = 30,unique = true)
	private String nombre;

	@Column(nullable = true, length = 30)
	private String departamento;

	@Column(nullable = true, length = 150)
	private String localidad;

	@Enumerated
	@Column(nullable = true)
	private EstadoITR estadoITR;

}
