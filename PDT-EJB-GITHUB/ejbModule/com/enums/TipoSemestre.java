package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum TipoSemestre {

	Semestre_1("Semestre", 1), Semestre_2("Semestre", 2), Semestre_3("Semestre", 3), Semestre_4("Semestre", 4),
	Semestre_5("Semestre", 5), Semestre_6("Semestre", 6), Semestre_7("Semestre", 7), Semestre_8("Semestre", 8);

	private String nombre;
	private int id;
}
