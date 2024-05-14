package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.Convocatoria_AsistenciaDTO;
import com.entities.Convocatoria_Asistencia;
import com.exception.ServiciosException;

public class Convocatoria_AsistenciaImp implements Convocatoria_AsistenciaBeanRemote {
	private Convocatoria_AsistenciaBeanRemote convocatoria_AsistenciaBean;

	@Override
	public void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria_Asistencia)
			throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoria_AsistenciaBean.crearConvocatoria_Asistencia(convocatoria_Asistencia);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria_Asistencia)
			throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoria_AsistenciaBean.modificarConvocatoria_Asistencia(convocatoria_Asistencia);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public void borrarConvocatoria_Asistencia(Long id) throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoria_AsistenciaBean.borrarConvocatoria_Asistencia(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencias() throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			return convocatoria_AsistenciaBean.obtenerTodosConvocatoria_Asistencias();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id) throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			return convocatoria_AsistenciaBean.obtenerPorIdConvocatoria_Asistencia(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Convocatoria_Asistencia obtenerPorNombreConvocatoria_Asistencia(String nombre) throws ServiciosException {
		try {
			convocatoria_AsistenciaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext.doLookup(
					"ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			return convocatoria_AsistenciaBean.obtenerPorNombreConvocatoria_Asistencia(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}
}
