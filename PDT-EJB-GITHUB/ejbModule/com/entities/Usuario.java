package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;

import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "genUsuario", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "genUsuario")
	private long idUsuario;

	@Column(nullable = false, length = 30)
	private String nombre;

	@Column(nullable = false, length = 30)
	private String apellido;

	@Column(nullable = false, length = 30,unique = true)
	private int documento;

	@Column(nullable = false, length = 30)
	private String departamento;

	@Column(nullable = false, length = 30)
	private String telefono;

	@Column(nullable = true, length = 30)
	private String nombreUsuario;

	@Column(nullable = false, length = 30)
	private String genero;

	@Column(nullable = false, length = 30)
	private String localidad;

	@Column(nullable = false, length = 500)
	private String mail;

	@Column(nullable = false, length = 500)
	private String mailInstitucional;

	@Column(nullable = false, length = 30)
	private Date fechaNac;

	@Column(nullable = false, length = 30)
	private String Contrasenia;

	@ManyToOne(optional = false)
	private ITR itr;

	@Enumerated
	@Column(nullable = false, length = 30)
	private EstadoUsuario estadoUsuario;

	@Enumerated
	@Column(nullable = false, length = 30)
	private TipoUsuario tipoUsuario;

}
