package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.EstudianteDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface EstudianteBeanRemote {
	void crearEstudiante(EstudianteDTO estudiante) throws ServiciosException;

	void borrarEstudiante(Long id) throws ServiciosException;

	void asignarITR(Long idEstudiante, Long idITR) throws ServiciosException;

	List<Estudiante> obtenerTodosEstudiantes();

	void modificar(EstudianteDTO estudiante) throws ServiciosException;

	Estudiante obtenerPorIdEstudiante(Long id);

	Estudiante obtenerPorNombreEstudiante(String nombre);

}
