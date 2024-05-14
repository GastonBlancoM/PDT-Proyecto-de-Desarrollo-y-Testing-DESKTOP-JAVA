package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EstadoUsuario {

	SinValidar("Sin validar", 1), Validado("Validado", 2), Eliminado("Eliminado", 3);

	private String nombre;
	private int id;

}
