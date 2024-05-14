package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EstadoEvento {
	Finalizado("Finalizado", 1), Corriente("Corriente", 2), Futuro("Futuro", 3);
	
	private String nombre;
	private int id;
}
