package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.EstudianteDTO;
import com.entities.Estudiante;
import com.exception.ServiciosException;

public class EstudianteBeanImp implements EstudianteBeanCliente {
	private EstudianteBeanRemote estudianteBean;

	@Override
	public void crearEstudiante(EstudianteDTO estudiante) throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			estudianteBean.crearEstudiante(estudiante);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public List<Estudiante> obtenerTodosEstudiantes() throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			return estudianteBean.obtenerTodosEstudiantes();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarEstudiante(Long id) throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			estudianteBean.borrarEstudiante(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public void modificarEstudiante(EstudianteDTO estudiante) throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			estudianteBean.modificar(estudiante);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Estudiante obtenerPorIdEstudiante(Long id) throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			return estudianteBean.obtenerPorIdEstudiante(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Estudiante obtenerPorNombreEstudiante(String nombre) throws ServiciosException {
		try {
			estudianteBean = (EstudianteBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/EstudianteBean!com.servicios.EstudianteBeanRemote");
			return estudianteBean.obtenerPorNombreEstudiante(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

}
