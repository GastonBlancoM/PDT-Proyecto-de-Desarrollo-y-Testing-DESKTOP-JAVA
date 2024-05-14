package com.servicios;

import java.util.List;
import javax.ejb.Remote;
import com.dto.ITRDTO;
import com.entities.ITR;
import com.enums.EstadoITR;
import com.exception.ServiciosException;

@Remote

public interface ITRBeanRemote {

	void crearITR(ITRDTO itr) throws ServiciosException;

	void borrarITR(Long id) throws ServiciosException;

	void modificarITR(ITRDTO itr) throws ServiciosException;

	List<ITR> obtenerTodosITR();
	
	List<ITR> obtenerPorEstadoITR(EstadoITR estado);

	ITR obtenerPorNombreITR(String nom);
	
	ITR obtenerPorIdITR(Long id);


}
