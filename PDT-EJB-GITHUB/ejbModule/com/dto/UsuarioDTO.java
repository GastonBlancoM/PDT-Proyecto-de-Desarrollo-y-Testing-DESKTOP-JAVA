package com.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.entities.ITR;
import com.enums.EstadoUsuario;
import com.enums.TipoRol;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class UsuarioDTO implements Serializable {

	private long idUsuario;

	private String nombre;

	private String apellido;

	private int documento;

	private String departamento;

	private String telefono;

	private String nombreUsuario;

	private String genero;

	private String localidad;

	private String mail;

	private String mailInstitucional;

	private Date fechaNac;

	private String Contrasenia;
	
	private EstadoUsuario estadoUsuario;
	
	private ITR itr;
}
