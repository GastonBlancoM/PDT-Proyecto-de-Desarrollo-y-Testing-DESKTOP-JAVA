package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.EventoDTO;
import com.dto.UsuarioDTO;
import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface EventoBeanRemote {
	void crearEvento(EventoDTO evento) throws ServiciosException;

	void borrarEvento(Long id) throws ServiciosException;

	List<Evento> obtenerTodosEventos();

	
	void modificar(EventoDTO evento) throws ServiciosException;

	Evento obtenerPorIdEvento(Long id);

	Evento obtenerPorNombreEvento(String nombre);
}
