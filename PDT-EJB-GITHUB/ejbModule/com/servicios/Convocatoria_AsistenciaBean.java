package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.Convocatoria_AsistenciaDTO;
import com.entities.Convocatoria_Asistencia;
import com.entities.ITR;
import com.entities.Convocatoria_Asistencia.Convocatoria_AsistenciaBuilder;
import com.entities.Convocatoria_Asistencia;
import com.exception.ServiciosException;

@Stateless
public class Convocatoria_AsistenciaBean implements Convocatoria_AsistenciaBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public Convocatoria_AsistenciaBean() {

	}

	@Override
	public void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria_Asistencia)
			throws ServiciosException {
		try {
			Convocatoria_Asistencia convoA = Convocatoria_Asistencia.builder()
					.calificacion(convocatoria_Asistencia.getCalificacion())
					.tipoAsistencia(convocatoria_Asistencia.getTipoAsistencia())
					.evento(convocatoria_Asistencia.getEvento()).estudiante(convocatoria_Asistencia.getEstudiante())
					.build();
			em.persist(convoA);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el el evento");
		}
	}

	@Override
	public void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO tutor) throws ServiciosException {
		try {
			Convocatoria_Asistencia convAs = em.find(Convocatoria_Asistencia.class, tutor.getIdConvocatoria_Ast());
			convAs.setCalificacion(convAs.getCalificacion());
			convAs.setTipoAsistencia(convAs.getTipoAsistencia());
			convAs.setEstudiante(convAs.getEstudiante());
			convAs.setEvento(convAs.getEvento());
			if (convAs != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el convA");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el convA");
		}
	}

	@Override
	public void borrarConvocatoria_Asistencia(Long id) throws ServiciosException {
		try {
			Convocatoria_Asistencia ast = em.find(Convocatoria_Asistencia.class, id);
			em.remove(ast);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la Convocatoria_Asistencia");
		}
	}

	@Override
	public List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencias() {
		TypedQuery<Convocatoria_Asistencia> query = em.createQuery("SELECT i FROM Convocatoria_Asistencia i",
				Convocatoria_Asistencia.class);
		return query.getResultList();
	}

	@Override
	public Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id) {
		TypedQuery<Convocatoria_Asistencia> query = em
				.createQuery("SELECT u FROM Convocatoria_Asistencia u WHERE u.idConvocatoria_Asistencia = :id",
						Convocatoria_Asistencia.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Convocatoria_Asistencia obtenerPorNombreConvocatoria_Asistencia(String nombre) {
		TypedQuery<Convocatoria_Asistencia> query = em
				.createQuery("SELECT i FROM Convocatoria_Asistencia i WHERE i.nombre = :nom",
						Convocatoria_Asistencia.class)
				.setParameter("nom", nombre);
		return query.getSingleResult();
	}

}
