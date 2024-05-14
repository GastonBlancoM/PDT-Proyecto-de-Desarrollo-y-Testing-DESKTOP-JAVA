package com.enums;

import java.util.Date;

import com.entities.Accion_Constancia;
import com.entities.Analista;
import com.entities.Constancia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EstadoConstancia {

Ingresado("Ingresado",1),En_Proceso("En Proceso",2),Finalizado("Finalizado",3);
	
private String nombre;
private int id;

}
