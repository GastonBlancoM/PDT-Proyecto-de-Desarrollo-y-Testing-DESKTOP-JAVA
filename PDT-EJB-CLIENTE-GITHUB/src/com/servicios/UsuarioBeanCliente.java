package com.servicios;

import java.util.List;

import com.dto.EstudianteDTO;
import com.dto.UsuarioDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public interface UsuarioBeanCliente {

	void crearUsuario(UsuarioDTO usuario) throws ServiciosException;

	void borrarUsuario(Long id) throws ServiciosException;

	List<Usuario> obtenerTodosUsuarios() throws ServiciosException;
	
	List<Usuario> buscarPorTipoUsuario(TipoUsuario estado) throws ServiciosException;
	
	List<Usuario> obtenerPorFiltros(TipoUsuario tipoUsuario, ITR itr, EstadoUsuario estado) throws ServiciosException;

	void modificarUsuario(UsuarioDTO usuario) throws ServiciosException;

	Usuario obtenerPorIdUsuario(Long id) throws ServiciosException;

	Usuario obtenerPorNombreUsuario(String nombre) throws ServiciosException;
	
}
