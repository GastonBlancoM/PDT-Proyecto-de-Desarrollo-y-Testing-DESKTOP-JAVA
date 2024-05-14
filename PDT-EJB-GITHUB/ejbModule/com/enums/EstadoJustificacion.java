package com.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public enum EstadoJustificacion {

INGRESADO("Ingresado",1),FINALIZADO("Finalizado",2),EN_PROCESO("En Proceso",1);
	
	private String nombre;
	private int id;	
}
