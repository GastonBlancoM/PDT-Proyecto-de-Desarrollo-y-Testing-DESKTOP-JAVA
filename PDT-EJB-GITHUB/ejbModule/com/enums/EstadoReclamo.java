package com.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum EstadoReclamo {
	INGRESADO("Ingresado",1),FINALIZADO("Finalizado",2),EN_PROCESO("En Proceso",3);
	private String nombre;
	private int id;	
}
