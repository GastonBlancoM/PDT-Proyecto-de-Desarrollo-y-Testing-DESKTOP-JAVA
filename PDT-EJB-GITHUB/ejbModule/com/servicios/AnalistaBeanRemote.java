package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.AnalistaDTO;
import com.dto.EstudianteDTO;
import com.entities.Analista;
import com.entities.Estudiante;
import com.exception.ServiciosException;

@Remote
public interface AnalistaBeanRemote {
	void crearAnalista(AnalistaDTO analista) throws ServiciosException;

	void borrarAnalista(Long id) throws ServiciosException;

	void asignarITR(Long idAnalista, Long idITR) throws ServiciosException;

	List<Analista> obtenerTodosAnalista();

	void modificar(AnalistaDTO analista) throws ServiciosException;

	Analista obtenerPorIdAnalista(Long id) throws ServiciosException;

	Analista obtenerPorNombreAnalista(String nombre) throws ServiciosException;

//	Analista obtenerPorIdAnalista(Long id);
//
//	Analista obtenerPorNombreAnalista(String nombre);

}
