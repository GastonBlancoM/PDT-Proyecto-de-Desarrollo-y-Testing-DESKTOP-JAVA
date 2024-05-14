package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.EventoDTO;
import com.dto.UsuarioDTO;
import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServiciosException;

public class EventoBeanImp implements EventoBeanCliente {

	private EventoBeanRemote eventoBean;

	@Override
	public void crearEvento(EventoDTO evento) throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			eventoBean.crearEvento(evento);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarEvento(Long id) throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			eventoBean.borrarEvento(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Evento> obtenerTodosEventos() throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			return eventoBean.obtenerTodosEventos();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarEvento(EventoDTO evento) throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			eventoBean.modificar(evento);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Evento obtenerPorIdEvento(Long id) throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			return eventoBean.obtenerPorIdEvento(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Evento obtenerPorNombreEvento(String nombre) throws ServiciosException {
		try {
			eventoBean = (EventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EventoBean!com.servicios.EventoBeanRemote");
			return eventoBean.obtenerPorNombreEvento(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}
}
