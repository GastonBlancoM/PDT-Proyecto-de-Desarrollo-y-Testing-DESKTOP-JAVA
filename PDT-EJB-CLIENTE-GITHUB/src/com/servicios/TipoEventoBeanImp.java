package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.TipoEventoDTO;
import com.entities.TipoEvento;
import com.enums.EstadoTipoEvento;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public class TipoEventoBeanImp implements TipoEventoBeanCliente {
	private TipoEventoBeanRemote tipoEventoBean;

	@Override
	public void crearTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			tipoEventoBean.crearTipoEvento(tipoEvento);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarTipoEvento(Long id) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			tipoEventoBean.borrarTipoEvento(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<TipoEvento> obtenerTodosTipoEventos() throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			return tipoEventoBean.obtenerTodosTipoEvento();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			tipoEventoBean.modificarTipoEvento(tipoEvento);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public TipoEvento obtenerPorIdTipoEvento(Long id) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			return tipoEventoBean.obtenerPorIdTipoEvento(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public TipoEvento obtenerPorNombreTipoEvento(String nombre) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			return tipoEventoBean.obtenerPorNombreTipoEvento(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}

	@Override
	public List<TipoEvento> obtenerPorEstadoTipoEvento(EstadoTipoEvento estado) throws ServiciosException {
		try {
			tipoEventoBean = (TipoEventoBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TipoEventoBean!com.servicios.TipoEventoBeanRemote");
			return tipoEventoBean.obtenerPorEstadoTipoEvento(estado);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}
}
