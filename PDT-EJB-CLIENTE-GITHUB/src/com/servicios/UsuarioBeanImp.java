package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.UsuarioDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public class UsuarioBeanImp implements UsuarioBeanCliente {
	private UsuarioBeanRemote usuarioBean;

	@Override
	public void crearUsuario(UsuarioDTO usuario) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			usuarioBean.crearUsuario(usuario);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarUsuario(Long id) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			usuarioBean.borrarUsuario(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			return usuarioBean.obtenerTodosUsuarios();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarUsuario(UsuarioDTO usuario) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			usuarioBean.modificar(usuario);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Usuario obtenerPorIdUsuario(Long id) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			return usuarioBean.obtenerPorIdUsuario(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Usuario obtenerPorNombreUsuario(String nombre) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			return usuarioBean.obtenerPorNombreUsuario(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}

	@Override
	public List<Usuario> buscarPorTipoUsuario(TipoUsuario estado) throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			return usuarioBean.obtenerPorEstadoUsuario(estado);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Usuario> obtenerPorFiltros(TipoUsuario tipoUsuario, ITR itr, EstadoUsuario estado)
			throws ServiciosException {
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/UsuarioBean!com.servicios.UsuarioBeanRemote");
			return usuarioBean.obtenerPorFiltros(tipoUsuario, itr, estado);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}
}
