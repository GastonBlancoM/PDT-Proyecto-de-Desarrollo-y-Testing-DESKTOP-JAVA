package com.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import com.entities.ITR;
import com.enums.EstadoITR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ITRDTO implements Serializable {

	private long idITR;

	private String nombre;

	private String departamento;

	private String localidad;

	private EstadoITR estadoITR;

}
