package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.TutorDTO;
import com.dto.UsuarioDTO;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServiciosException;

public class TutorBeanImp implements TutorBeanCliente {
	private TutorBeanRemote tutorBean;

	@Override
	public void crearTutor(TutorDTO tutor) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			tutorBean.crearTutor(tutor);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public List<Tutor> obtenerTodosTutores() throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			return tutorBean.obtenerTodosTutores();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}
	}

	@Override
	public void borrarTutor(Long id) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			tutorBean.borrarTutor(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public void modificarTutor(TutorDTO tutor) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			tutorBean.modificar(tutor);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Tutor obtenerPorIdTutor(Long id) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			return tutorBean.obtenerPorIdTutor(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Tutor obtenerPorNombreTutor(String nombre) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			return tutorBean.obtenerPorNombreTutor(nombre);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}

	@Override
	public Tutor oBuscaOBusca(Long id) throws ServiciosException {
		try {
			tutorBean = (TutorBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/TutorBean!com.servicios.TutorBeanRemote");
			return tutorBean.buscarTutor(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}
	}
}
