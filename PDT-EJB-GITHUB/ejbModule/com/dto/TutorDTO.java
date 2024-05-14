package com.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoEstudiante;
import com.enums.TipoRol;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TutorDTO extends UsuarioDTO implements Serializable {

	private TipoRol tipoRol;

	private TipoUsuario tipoUsuario;
	
	private String Area;

}
