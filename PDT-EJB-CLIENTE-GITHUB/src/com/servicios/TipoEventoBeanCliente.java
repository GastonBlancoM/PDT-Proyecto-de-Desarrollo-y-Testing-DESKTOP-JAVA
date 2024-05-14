package com.servicios;

import java.util.List;

import com.dto.AnalistaDTO;
import com.dto.TipoEventoDTO;
import com.entities.Analista;
import com.entities.TipoEvento;
import com.enums.EstadoTipoEvento;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public interface TipoEventoBeanCliente {
	void crearTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException;

	void borrarTipoEvento(Long id) throws ServiciosException;

	List<TipoEvento> obtenerTodosTipoEventos() throws ServiciosException;

	List<TipoEvento> obtenerPorEstadoTipoEvento(EstadoTipoEvento estadoTipoEvento) throws ServiciosException;

	void modificarTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException;

	TipoEvento obtenerPorIdTipoEvento(Long id) throws ServiciosException;

	TipoEvento obtenerPorNombreTipoEvento(String nombre) throws ServiciosException;

}
