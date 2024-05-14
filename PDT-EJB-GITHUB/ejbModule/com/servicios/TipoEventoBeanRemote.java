package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.ITRDTO;
import com.dto.TipoEventoDTO;
import com.entities.ITR;
import com.entities.TipoEvento;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.enums.EstadoTipoEvento;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Remote
public interface TipoEventoBeanRemote {
	void crearTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException;

	void borrarTipoEvento(Long id) throws ServiciosException;

	void modificarTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException;

	List<TipoEvento> obtenerTodosTipoEvento() throws ServiciosException;

	List<TipoEvento> obtenerPorEstadoTipoEvento(EstadoTipoEvento estado) throws ServiciosException;

	TipoEvento obtenerPorNombreTipoEvento(String nom) throws ServiciosException;

	TipoEvento obtenerPorIdTipoEvento(Long id) throws ServiciosException;

}
