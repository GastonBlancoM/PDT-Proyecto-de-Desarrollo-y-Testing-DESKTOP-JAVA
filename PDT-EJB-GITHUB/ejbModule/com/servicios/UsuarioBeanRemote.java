package com.servicios;

import java.util.List;
import javax.ejb.Remote;
import com.dto.UsuarioDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	void crearUsuario(UsuarioDTO usuario) throws ServiciosException;

	void borrarUsuario(Long id) throws ServiciosException;

	void asignarITR(Long idUsuario, Long idITR) throws ServiciosException;

	List<Usuario> obtenerTodosUsuarios();

	List<Usuario> obtenerPorEstadoUsuario(TipoUsuario estado);

	void modificar(UsuarioDTO usuario) throws ServiciosException;

	Usuario obtenerPorIdUsuario(Long id);
	
	List<Usuario> obtenerPorFiltros(TipoUsuario tipoUsuario, ITR itr, EstadoUsuario estado);

	Usuario obtenerPorNombreUsuario(String nombre);
}
