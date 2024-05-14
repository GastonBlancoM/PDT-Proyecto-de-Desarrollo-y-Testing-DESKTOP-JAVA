package com.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EstadoEstudiante {
	Activo("Activo", 1), Congelado("Congelado", 2), No_Matriculado("No Matriculado", 3);

	private String nombre;
	private int id;

}
