package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.enums.EstadoEstudiante;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor

@Getter
@Setter
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Analista extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

}
