package com.servicios;

import java.util.List;
import com.dto.EventoDTO;
import com.entities.Evento;
import com.exception.ServiciosException;

public interface EventoBeanCliente {
	void crearEvento(EventoDTO evento) throws ServiciosException;

	void borrarEvento(Long id) throws ServiciosException;

	List<Evento> obtenerTodosEventos() throws ServiciosException;

	void modificarEvento(EventoDTO evento) throws ServiciosException;

	Evento obtenerPorIdEvento(Long id) throws ServiciosException;

	Evento obtenerPorNombreEvento(String nombre) throws ServiciosException;
}
