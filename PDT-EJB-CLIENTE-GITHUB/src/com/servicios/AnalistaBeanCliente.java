package com.servicios;

import java.util.List;

import com.dto.AnalistaDTO;
import com.dto.EstudianteDTO;
import com.dto.UsuarioDTO;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.Usuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

public interface AnalistaBeanCliente {
	void crearAnalista(AnalistaDTO analista) throws ServiciosException;

	void borrarAnalista(Long id) throws ServiciosException;

	List<Analista> obtenerTodosAnalistas() throws ServiciosException;
	

	void modificarAnalista(AnalistaDTO analista) throws ServiciosException;

	Analista obtenerPorIdAnalista(Long id) throws ServiciosException;

	Analista obtenerPorNombreAnalista(String nombre) throws ServiciosException;
}
