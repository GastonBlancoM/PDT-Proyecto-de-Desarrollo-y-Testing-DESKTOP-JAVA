package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.AnalistaDTO;
import com.dto.UsuarioDTO;
import com.entities.Analista;
import com.entities.Usuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public class AnalistaBeanImp implements AnalistaBeanCliente {
	private AnalistaBeanRemote analistaBean;

	@Override
	public void crearAnalista(AnalistaDTO analista) throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			analistaBean.crearAnalista(analista);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarAnalista(Long id) throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			analistaBean.borrarAnalista(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Analista> obtenerTodosAnalistas() throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			return analistaBean.obtenerTodosAnalista();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarAnalista(AnalistaDTO analista) throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			analistaBean.modificar(analista);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Analista obtenerPorIdAnalista(Long id) throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			return analistaBean.obtenerPorIdAnalista(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Analista obtenerPorNombreAnalista(String nombre) throws ServiciosException {
		try {
			analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/AnalistaBean!com.servicios.AnalistaBeanRemote");
			return analistaBean.obtenerPorNombreAnalista(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}

}
