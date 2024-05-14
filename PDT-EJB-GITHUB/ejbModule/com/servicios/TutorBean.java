package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.TutorDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Stateless
public class TutorBean implements TutorBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public TutorBean() {

	}

	@Override
	public void crearTutor(TutorDTO tutor) throws ServiciosException {
		try {
			Tutor tuto = new Tutor();
			tuto.setNombre(tutor.getNombre());
			tuto.setApellido(tutor.getApellido());
			tuto.setDocumento(tutor.getDocumento());
			tuto.setDepartamento(tutor.getDepartamento());
			tuto.setTelefono(tutor.getTelefono());
			tuto.setNombreUsuario(tutor.getNombreUsuario());
			tuto.setGenero(tutor.getGenero());
			tuto.setLocalidad(tutor.getLocalidad());
			tuto.setMail(tutor.getMail());
			tuto.setMailInstitucional(tutor.getMailInstitucional());
			tuto.setFechaNac(tutor.getFechaNac());
			tuto.setContrasenia(tutor.getContrasenia());
			tuto.setItr(tutor.getItr());
			tuto.setEstadoUsuario(tutor.getEstadoUsuario());
			tuto.setTipoUsuario(tutor.getTipoUsuario());
			tuto.setTipoRol(tutor.getTipoRol());
			tuto.setArea(tutor.getArea());

			em.persist(tuto);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el tutor");
		}
	}

	@Override
	public void asignarITRTutor(Long idTutor, Long idITR) throws ServiciosException {
		try {
			Tutor tutor = em.find(Tutor.class, idTutor);
			tutor.setItr(em.find(ITR.class, idITR));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el ITR al tutor");
		}
	}

	@Override
	public List<Tutor> obtenerTodosTutores() {
		TypedQuery<Tutor> query = em.createQuery("SELECT i FROM Tutor i", Tutor.class);
		return query.getResultList();
	}

	@Override
	public void borrarTutor(Long id) throws ServiciosException {
		try {
			Tutor tutor = em.find(Tutor.class, id);
			em.remove(tutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el tutor tutor");
		}
	}

	@Override
	public void modificar(TutorDTO tutor) throws ServiciosException {
		try {
			Tutor tut = em.find(Tutor.class, tutor.getIdUsuario());
		
			tut.setNombre(tutor.getNombre());
			tut.setApellido(tutor.getApellido());
			tut.setDocumento(tutor.getDocumento());
			tut.setDepartamento(tutor.getDepartamento());
			tut.setTelefono(tutor.getTelefono());
			tut.setNombreUsuario(tutor.getNombreUsuario());
			tut.setGenero(tutor.getGenero());
			tut.setLocalidad(tutor.getLocalidad());
			tut.setMail(tutor.getMail());
			tut.setMailInstitucional(tutor.getMailInstitucional());
			tut.setFechaNac(tutor.getFechaNac());
			tut.setContrasenia(tutor.getContrasenia());
			tut.setItr(tutor.getItr());
			tut.setEstadoUsuario(tutor.getEstadoUsuario());
			tut.setTipoRol(tutor.getTipoRol());
			tut.setTipoUsuario(tutor.getTipoUsuario());
			tut.setArea(tutor.getArea());
			if (tut != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el tutor");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el tutor");
		}
	}

	@Override
//	and u.generacion = :gen
	public Tutor obtenerPorIdTutor(Long id) {
		TypedQuery<Tutor> query = em.createQuery("SELECT u FROM Tutor u WHERE u.idUsuario = :id and u.tipoUsuario=:tipoUsuario", Tutor.class)
				.setParameter("id", id).setParameter("tipoUsuario", TipoUsuario.Tutor);
		
		return query.getSingleResult();
	}

	@Override
	public Tutor obtenerPorNombreTutor(String nombre) {
		TypedQuery<Tutor> query = em.createQuery("SELECT u FROM Tutor u WHERE u.nombre = :nombre", Tutor.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();
	}
	public Tutor buscarTutor(Long id) {
		Tutor tut = em.find(Tutor.class, id);

		return tut;
	}
}
