package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.TipoEventoDTO;
import com.entities.ITR;
import com.entities.TipoEvento;
import com.entities.Tutor;
import com.entities.Usuario;
import com.enums.EstadoTipoEvento;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;

@Stateless
public class TipoEventoBean implements TipoEventoBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public TipoEventoBean() {

	}

	@Override
	public void crearTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException {
		try {
			TipoEvento tE = TipoEvento.builder().nombre(tipoEvento.getNombre())
					.estadoTipoEvento(tipoEvento.getEstadoTipoEvento()).build();
			em.persist(tE);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Tipo de Evento");
		}
	}

	@Override
	public void borrarTipoEvento(Long id) throws ServiciosException {
		try {
			TipoEvento tE = em.find(TipoEvento.class, id);
			em.remove(tE);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el Tipo Evento");
		}
	}

	@Override
	public void modificarTipoEvento(TipoEventoDTO tipoEvento) throws ServiciosException {
		try {
			TipoEvento tE = em.find(TipoEvento.class, tipoEvento.getIdTipoEvento());

			tE.setNombre(tipoEvento.getNombre());
			tE.setEstadoTipoEvento(tipoEvento.getEstadoTipoEvento());

			if (tE != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el itr");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el itr");
		}
	}

	@Override
	public List<TipoEvento> obtenerTodosTipoEvento() {
		TypedQuery<TipoEvento> query = em.createQuery("SELECT i FROM TipoEvento i", TipoEvento.class);
		return query.getResultList();
	}

	@Override
	public TipoEvento obtenerPorNombreTipoEvento(String nom) {
		TypedQuery<TipoEvento> query = em
				.createQuery("SELECT i FROM TipoEvento i WHERE i.nombre = :nom", TipoEvento.class)
				.setParameter("nom", nom);
		return query.getSingleResult();

	}

	@Override
	public TipoEvento obtenerPorIdTipoEvento(Long id) {
		TypedQuery<TipoEvento> query = em
				.createQuery("SELECT u FROM TipoEvento u WHERE u.idTipoEvento = :id", TipoEvento.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<TipoEvento> obtenerPorEstadoTipoEvento(EstadoTipoEvento estado) throws ServiciosException {
		TypedQuery<TipoEvento> query = em
				.createQuery("SELECT i FROM TipoEvento i WHERE i.estadoTipoEvento = :estado", TipoEvento.class)
				.setParameter("estado", estado);
		return query.getResultList();

	}

}
