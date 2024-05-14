package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum TipoRol {
	Tutor("Tutor", 1), Encargado("Encargado", 2);

	private String nombre;
	private int id;
}
