package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Modalidad {
Presencial("Presencial",1),Virtual("Virtual",2),Semi_Presencial("SemiPresencial",3);
private String nombre;
private int id;	
}
