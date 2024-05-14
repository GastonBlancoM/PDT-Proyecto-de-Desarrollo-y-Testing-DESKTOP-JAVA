package com.servicios;

import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.dto.UsuarioDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext
	private EntityManager em;

	public UsuarioBean() {

	}

	@Override
	public void crearUsuario(UsuarioDTO usuario) throws ServiciosException {
		try {
			Usuario est = Usuario.builder().nombre(usuario.getNombre()).apellido(usuario.getApellido())
					.documento(usuario.getDocumento()).departamento(usuario.getDepartamento())
					.telefono(usuario.getTelefono()).nombreUsuario(usuario.getNombreUsuario())
					.genero(usuario.getGenero()).localidad(usuario.getLocalidad()).mail(usuario.getMail())
					.mailInstitucional(usuario.getMailInstitucional()).fechaNac(usuario.getFechaNac())
					.Contrasenia(usuario.getContrasenia()).itr(usuario.getItr()).build();
			em.persist(est);
			em.flush();

		} catch (PersistenceException e) {

			throw new ServiciosException("No se pudo crear el Estudiante");
		}
	}

	@Override
	public void borrarUsuario(Long id) throws ServiciosException {
		try {
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el usuario usuario");
		}
	}

	@Override
	public void asignarITR(Long idUsuario, Long idITR) throws ServiciosException {
		try {
			Usuario usuario = em.find(Usuario.class, idUsuario);
			usuario.setItr(em.find(ITR.class, idITR));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el ITR al Usuario");
		}

	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		TypedQuery<Usuario> query = em.createQuery("SELECT e FROM Usuario e ORDER BY e.idUsuario ASC", Usuario.class);
		return query.getResultList();

	}

	@Override
	public void modificar(UsuarioDTO usuario) throws ServiciosException {
		try {
			Usuario est = em.find(Usuario.class, usuario.getIdUsuario());
			est.setNombre(usuario.getNombre());
			est.setApellido(usuario.getApellido());
			est.setDocumento(usuario.getDocumento());
			est.setDepartamento(usuario.getDepartamento());
			est.setTelefono(usuario.getTelefono());
			est.setNombreUsuario(usuario.getNombreUsuario());
			est.setGenero(usuario.getGenero());
			est.setLocalidad(usuario.getLocalidad());
			est.setMail(usuario.getMail());
			est.setMailInstitucional(usuario.getMailInstitucional());
			est.setFechaNac(usuario.getFechaNac());
			est.setContrasenia(usuario.getContrasenia());
			est.setItr(usuario.getItr());
			est.setEstadoUsuario(usuario.getEstadoUsuario());
			if (est != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el usuario");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el usuario");
		}
	}
//	.idUsuario,u.nombre,u.apellido
	@Override
	public Usuario obtenerPorIdUsuario(Long id) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id", Usuario.class)
				.setParameter("id", id);
		return query.getSingleResult();

	}

	@Override
	public Usuario obtenerPorNombreUsuario(String nombre) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();

	}

	@Override
	public List<Usuario> obtenerPorEstadoUsuario(TipoUsuario estado) {
		TypedQuery<Usuario> query = em
				.createQuery("SELECT i FROM Usuario i WHERE i.estadoUsuario = :estado", Usuario.class)
				.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorFiltros(TipoUsuario tipoUsuario, ITR itr, EstadoUsuario estado) {
		CriteriaBuilder criteriaB = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> confConsult = criteriaB.createQuery(Usuario.class);

		Root<Usuario> raiz = confConsult.from(Usuario.class);

		confConsult.select(raiz);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (tipoUsuario != null) {
			predicates.add(criteriaB.equal(raiz.get("tipoUsuario"), tipoUsuario));
		}

		if (itr != null) {
			predicates.add(criteriaB.equal(raiz.get("itr"), itr));
		}
		if (estado != null) {
			predicates.add(criteriaB.equal(raiz.get("estadoUsuario"), estado));

		}
		confConsult.where(criteriaB.and(predicates.toArray(new Predicate[predicates.size()])));
		return em.createQuery(confConsult).getResultList();

	}
}
