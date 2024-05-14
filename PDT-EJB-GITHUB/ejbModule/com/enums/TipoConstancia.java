package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoConstancia {
	Presencial("Presencial", 1), Transporte("Transporte", 2), Estudiante_ACTIVO("Estudiante_Activo", 3),
	Examen("Examen", 4), Credito_VME("Credito VME", 5), Credito_UTECInnova("Credito UTECInnova", 6),
	Credito_OPTATIVAS("Credito Optativas", 6);

	private String nombre;
	private int id;
}
