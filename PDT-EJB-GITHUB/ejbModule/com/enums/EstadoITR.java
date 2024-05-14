package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EstadoITR {
	ACTIVO("Activo", 1), DESACTIVADO("Desactivado", 2), ELIMINADO("Eliminado", 3);

	private String nombre;
	private int id;



}
