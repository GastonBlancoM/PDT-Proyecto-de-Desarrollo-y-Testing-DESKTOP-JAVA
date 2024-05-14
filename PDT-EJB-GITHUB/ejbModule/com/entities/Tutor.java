package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.enums.EstadoEstudiante;
import com.enums.TipoRol;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
//@NamedQueries({
//		@NamedQuery(name = "select.tutorid", query = "SELECT u FROM Tutor u WHERE u.idUsuario = :id and u.tipoUsuario=:tipoUsuario") })
public class Tutor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated
	@Column(nullable = true)
	private TipoRol tipoRol;

	@Column(nullable = true, length = 30)
	private String Area;

//	public Tutor() {
//		super();
//
//	}

//	@Override
//	public String toString() {
//		return "Tutor ["+super.getIdUsuario()+"tipoRol=" + tipoRol + ", Area=" + Area + "]";
//	}
	
}
