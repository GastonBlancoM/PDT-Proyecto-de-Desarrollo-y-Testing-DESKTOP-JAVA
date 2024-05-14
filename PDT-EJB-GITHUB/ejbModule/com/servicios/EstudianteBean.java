package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.EstudianteDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Stateless
public class EstudianteBean implements EstudianteBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public EstudianteBean() {

	}

	@Override
	public void crearEstudiante(EstudianteDTO estudiante) throws ServiciosException {
		try {
			Estudiante est = new Estudiante();

			est.setNombre(estudiante.getNombre());
			est.setApellido(estudiante.getApellido());
			est.setDocumento(estudiante.getDocumento());
			est.setDepartamento(estudiante.getDepartamento());
			est.setTelefono(estudiante.getTelefono());
			est.setNombreUsuario(estudiante.getNombreUsuario());
			est.setGenero(estudiante.getGenero());
			est.setLocalidad(estudiante.getLocalidad());
			est.setMail(estudiante.getMail());
			est.setMailInstitucional(estudiante.getMailInstitucional());
			est.setFechaNac(estudiante.getFechaNac());
			est.setContrasenia(estudiante.getContrasenia());
			est.setItr(estudiante.getItr());
			est.setEstadoEstudiante(estudiante.getEstadoEstudiante());
			est.setAñoIngreso(estudiante.getAñoIngreso());
			est.setEstadoUsuario(estudiante.getEstadoUsuario());
			est.setTipoUsuario(estudiante.getTipoUsuario());
			
			em.persist(est);
			em.flush();
		} catch (PersistenceException e) {

			throw new ServiciosException("No se pudo crear el Estudiante");
		}
	}

	@Override
	public void asignarITR(Long idEstudiante, Long idITR) throws ServiciosException {
		try {
			Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
			estudiante.setItr(em.find(ITR.class, idITR));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el ITR al Estudiante");
		}
	}

	@Override
	public List<Estudiante> obtenerTodosEstudiantes() {
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return query.getResultList();
	}

	@Override
	public void borrarEstudiante(Long id) throws ServiciosException {
		try {
			Estudiante estudiante = em.find(Estudiante.class, id);
			em.remove(estudiante);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el estudiante estudiante");
		}
	}

	@Override
	public void modificar(EstudianteDTO estudiante) throws ServiciosException {
		try {
			Estudiante est = em.find(Estudiante.class, estudiante.getIdUsuario());
			est.setNombre(estudiante.getNombre());
			est.setApellido(estudiante.getApellido());
			est.setDocumento(estudiante.getDocumento());
			est.setDepartamento(estudiante.getDepartamento());
			est.setTelefono(estudiante.getTelefono());
			est.setNombreUsuario(estudiante.getNombreUsuario());
			est.setGenero(estudiante.getGenero());
			est.setLocalidad(estudiante.getLocalidad());
			est.setMail(estudiante.getMail());
			est.setMailInstitucional(estudiante.getMailInstitucional());
			est.setFechaNac(estudiante.getFechaNac());
			est.setContrasenia(estudiante.getContrasenia());
			est.setItr(estudiante.getItr());
			est.setEstadoEstudiante(estudiante.getEstadoEstudiante());
			est.setEstadoUsuario(estudiante.getEstadoUsuario());
			est.setTipoUsuario(estudiante.getTipoUsuario());
			est.setAñoIngreso(estudiante.getAñoIngreso());
			if (est != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el estudiante");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el estudiante");
		}
	}

	@Override
	public Estudiante obtenerPorIdEstudiante(Long id) {
		TypedQuery<Estudiante> query = em
				.createQuery("SELECT u FROM Estudiante u WHERE u.idEstudiante = :id", Estudiante.class)
				.setParameter("id", id);
		return query.getSingleResult();

	}

	@Override
	public Estudiante obtenerPorNombreEstudiante(String nombre) {
		TypedQuery<Estudiante> query = em
				.createQuery("SELECT u FROM Estudiante u WHERE u.nombre = :nombre", Estudiante.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();

	}
}
