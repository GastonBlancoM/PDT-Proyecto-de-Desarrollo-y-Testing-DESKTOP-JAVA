package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.enums.EstadoEvento;
import com.enums.EstadoITR;
import com.enums.EstadoTipoEvento;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class TipoEvento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genTipoEvento", sequenceName = "SEQ_ID_TIPO_EVENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genTipoEvento")
	private long idTipoEvento;

	@Column(nullable = true, length = 30, unique = true)
	private String nombre;

	@Enumerated
	@Column(nullable = true)
	private EstadoTipoEvento estadoTipoEvento;
}
