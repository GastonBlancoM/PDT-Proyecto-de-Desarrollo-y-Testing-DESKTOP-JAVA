package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TipoAsistencia {
	Asistencia("Asistencia", 1), Media_Asistencia_Matutina("Media Asistencia Matutina", 2),
	Media_Asistencia_Vespertina("Media Asistencia Vespertina", 3),
	Media_Asistencia_Ausencia("Media Asistencia Ausencia", 4), Ausencia_justificada("Ausencia justificada",5);

	private String nombre;
	private int id;
}
