package com.servicios;

import java.util.List;

import com.dto.Convocatoria_AsistenciaDTO;
import com.entities.Convocatoria_Asistencia;
import com.entities.Usuario;
import com.exception.ServiciosException;

public interface ConvocatoriaBeanCliente {

	void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO usuario) throws ServiciosException;

	void borrarConvocatoria_Asistencia(Long id) throws ServiciosException;

	List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencia() throws ServiciosException;

	void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria) throws ServiciosException;

	Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id) throws ServiciosException;

}
