package com.servicios;

import java.util.List;

import com.dto.AnalistaDTO;
import com.dto.Convocatoria_AsistenciaDTO;
import com.entities.Analista;
import com.entities.Convocatoria_Asistencia;
import com.exception.ServiciosException;

public interface Convocatoria_AsistenciaCliente {
	void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO analista) throws ServiciosException;

	void borrarConvocatoria_Asistencia(Long id) throws ServiciosException;

	List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencias() throws ServiciosException;

	void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO analista) throws ServiciosException;

	Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id) throws ServiciosException;

	Convocatoria_Asistencia obtenerPorNombreConvocatoria_Asistencia(String nombre) throws ServiciosException;
}
