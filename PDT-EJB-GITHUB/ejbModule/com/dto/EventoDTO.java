package com.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.entities.Analista;
import com.entities.ITR;
import com.entities.TipoEvento;
import com.entities.Tutor;
import com.enums.EstadoEvento;
import com.enums.Modalidad;

import com.enums.TipoRol;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDTO implements Serializable {

	private long idEvento;

	private String Titulo;

	private Date fechaInicio;

	private Date fechaFinal;

	private String horaInicio;

	private String horaFinal;

	private String informacion;

	private TipoEvento tipoEvento;

	private Modalidad modalidad;

	private int creditos;

	private String localizacion;

	private EstadoEvento estadoEvento;

	private List<Analista> analistas = new ArrayList();

	private List<Tutor> tutores = new ArrayList();

	private ITR itr;

}
