package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.Convocatoria_AsistenciaDTO;
import com.dto.TutorDTO;
import com.entities.Convocatoria_Asistencia;
import com.entities.Tutor;
import com.exception.ServiciosException;

@Remote
public interface Convocatoria_AsistenciaBeanRemote {
	void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria_Asistencia) throws ServiciosException;

	void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO tutor) throws ServiciosException;

	void borrarConvocatoria_Asistencia(Long id) throws ServiciosException;

	List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencias()throws ServiciosException;

	Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id)throws ServiciosException;

	Convocatoria_Asistencia obtenerPorNombreConvocatoria_Asistencia(String nombre)throws ServiciosException;

}