package com.dto;

import java.io.Serializable;

import com.enums.EstadoITR;
import com.enums.EstadoTipoEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TipoEventoDTO implements Serializable {
	private long idTipoEvento;

	private String nombre;
	
	private EstadoTipoEvento estadoTipoEvento;

}
