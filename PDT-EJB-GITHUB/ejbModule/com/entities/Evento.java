package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.enums.EstadoEvento;
import com.enums.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EVENTOS")

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "genEvento", sequenceName = "SEQ_ID_EVENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genEvento")
	private long idEvento;

	@Column(nullable = true, length = 30)
	private String Titulo;

	@Column(nullable = true, length = 30)
	private Date fechaInicio;

	@Column(nullable = true, length = 30)
	private Date fechaFinal;
	
	@Column(nullable = true, length = 30)
	private String horaInicio;

	@Column(nullable = true, length = 30)
	private String horaFinal;
	

	@ManyToOne(optional = true)
	private TipoEvento tipoEvento;

	@Enumerated
	@Column(nullable = true)
	private Modalidad modalidad;

	@Column(nullable = true, length = 100)
	private String localizacion;

	@Enumerated
	@Column(nullable = true)
	private EstadoEvento estadoEvento;

	@ManyToMany
	private List<Analista> analistas = new ArrayList();

	@ManyToMany
	private List<Tutor> tutores = new ArrayList();

	@ManyToOne(optional = true)
	private ITR itr;

}