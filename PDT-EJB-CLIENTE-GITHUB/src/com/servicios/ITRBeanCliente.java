package com.servicios;

import java.util.List;

import com.dto.ITRDTO;

import com.entities.ITR;
import com.enums.EstadoITR;
import com.exception.ServiciosException;

public interface ITRBeanCliente {
	void crearITR(ITRDTO itr) throws ServiciosException;

	void borrarITR(Long id) throws ServiciosException;

	void modificarITR(ITRDTO itr) throws ServiciosException;

	List<ITR> obtenerTodosITR() throws ServiciosException;
	
	List<ITR> buscarPorEstadoITR(EstadoITR estado) throws ServiciosException;
	
	ITR obtenerTodosITRPorNombre(String nombre) throws ServiciosException;

	ITR obtenerPorIdITR(Long id) throws ServiciosException;

}
