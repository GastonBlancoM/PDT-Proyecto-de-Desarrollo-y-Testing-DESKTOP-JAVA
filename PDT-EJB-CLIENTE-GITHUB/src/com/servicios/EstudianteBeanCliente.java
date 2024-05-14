package com.servicios;

import java.util.List;
import javax.naming.NamingException;
import com.dto.EstudianteDTO;
import com.entities.Estudiante;
import com.exception.ServiciosException;

public interface EstudianteBeanCliente {
	void crearEstudiante(EstudianteDTO estudiante) throws ServiciosException;

	void borrarEstudiante(Long id) throws ServiciosException;

	List<Estudiante> obtenerTodosEstudiantes() throws ServiciosException;

	void modificarEstudiante(EstudianteDTO estudiante) throws ServiciosException;

	Estudiante obtenerPorIdEstudiante(Long id) throws ServiciosException;

	Estudiante obtenerPorNombreEstudiante(String nombre) throws ServiciosException;

}
