package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum EstadoTipoEvento {

	ACTIVO("Activo", 1), ELIMINADO("Eliminado", 2);

	private String nombre;
	private int id;

}
