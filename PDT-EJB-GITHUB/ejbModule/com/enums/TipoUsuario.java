package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum TipoUsuario {

	Analista("Analista",1),Tutor("Tutor",2),Estudiante("Estudiante",3);
	
	private String nombre;
	private int id;


}
