package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.EventoDTO;
import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Stateless
public class EventoBean implements EventoBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public EventoBean() {

	}

	@Override
	public void crearEvento(EventoDTO evento) throws ServiciosException {
		try {
			Evento eve = Evento.builder().Titulo(evento.getTitulo())
					.fechaInicio(evento.getFechaInicio())
					.fechaFinal(evento.getFechaFinal())
					.horaInicio(evento.getHoraInicio())
					.horaFinal(evento.getHoraFinal())
					.tipoEvento(evento.getTipoEvento())
					.modalidad(evento.getModalidad())
					.localizacion(evento.getLocalizacion())
					.estadoEvento(evento.getEstadoEvento())
					.analistas(evento.getAnalistas())
					.tutores(evento.getTutores())
					.itr(evento.getItr())
					.build();

			em.persist(eve);
			em.flush();

		} catch (PersistenceException e) {

			throw new ServiciosException("No se pudo crear el evento");
		}
	}

	@Override
	public void borrarEvento(Long id) throws ServiciosException {
		try {
			Evento evento = em.find(Evento.class, id);
			em.remove(evento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el Evento");
		}
	}

	@Override
	public List<Evento> obtenerTodosEventos() {
		TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e", Evento.class);
		return query.getResultList();

	}

	@Override
	public void modificar(EventoDTO evento) throws ServiciosException {
		try {
			Evento eve = em.find(Evento.class, evento.getIdEvento());
			eve.setTitulo(evento.getTitulo());
			eve.setFechaInicio(evento.getFechaInicio());
			eve.setFechaFinal(evento.getFechaFinal());
			eve.setHoraInicio(evento.getHoraInicio());
			eve.setHoraFinal(evento.getHoraFinal());
			eve.setTipoEvento(evento.getTipoEvento());
			eve.setModalidad(evento.getModalidad());
			eve.setLocalizacion(evento.getLocalizacion());
			eve.setEstadoEvento(evento.getEstadoEvento());
			eve.setAnalistas(evento.getAnalistas());
			eve.setTutores(evento.getTutores());
			eve.setItr(evento.getItr());
			

			if (eve != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el evento");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el evento");
		}
	}

	@Override
	public Evento obtenerPorIdEvento(Long id) {
		TypedQuery<Evento> query = em.createQuery("SELECT u FROM Evento u WHERE u.idEvento = :id", Evento.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Evento obtenerPorNombreEvento(String nombre) {
		TypedQuery<Evento> query = em.createQuery("SELECT u FROM Evento u WHERE u.nombre = :nombre", Evento.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

}
