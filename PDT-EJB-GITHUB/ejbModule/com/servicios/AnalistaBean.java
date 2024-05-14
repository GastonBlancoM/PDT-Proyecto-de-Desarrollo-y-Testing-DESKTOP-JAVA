package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.AnalistaDTO;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Stateless
public class AnalistaBean implements AnalistaBeanRemote {
	@PersistenceContext
	private EntityManager em;

	public AnalistaBean() {

	}

	@Override
	public void crearAnalista(AnalistaDTO analista) throws ServiciosException {
		try {
			Analista ana = new Analista();

			ana.setNombre(analista.getNombre());
			ana.setApellido(analista.getApellido());
			ana.setDocumento(analista.getDocumento());
			ana.setDepartamento(analista.getDepartamento());
			ana.setTelefono(analista.getTelefono());
			ana.setNombreUsuario(analista.getNombreUsuario());
			ana.setGenero(analista.getGenero());
			ana.setLocalidad(analista.getLocalidad());
			ana.setMail(analista.getMail());
			ana.setMailInstitucional(analista.getMailInstitucional());
			ana.setFechaNac(analista.getFechaNac());
			ana.setContrasenia(analista.getContrasenia());
			ana.setItr(analista.getItr());
			ana.setEstadoUsuario(analista.getEstadoUsuario());
			ana.setTipoUsuario(analista.getTipoUsuario());
			
			em.persist(ana);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el analista");
		}
	}
	@Override
	public void asignarITR(Long idAnalista, Long idITR) throws ServiciosException {
		try {
			Analista analista = em.find(Analista.class, idAnalista);
			analista.setItr(em.find(ITR.class, idITR));
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el ITR al Estudiante");
		}
	}

	 @Override
	    public List<Analista> obtenerTodosAnalista() {
	        TypedQuery<Analista> query = em.createQuery("SELECT i FROM Analista i", Analista.class);
	        return query.getResultList();
	    }

	@Override
	public void borrarAnalista(Long id) throws ServiciosException {
		try {
			Analista analista = em.find(Analista.class, id);
			em.remove(analista);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el analista analista");
		}
	
		
	}

	@Override
	public void modificar(AnalistaDTO analista) throws ServiciosException {
		
		try {
		Analista ana = em.find(Analista.class, analista.getIdUsuario());
		
		ana.setNombre(analista.getNombre());
		ana.setApellido(analista.getApellido());
		ana.setDocumento(analista.getDocumento());
		ana.setDepartamento(analista.getDepartamento());
		ana.setTelefono(analista.getTelefono());
		ana.setNombreUsuario(analista.getNombreUsuario());
		ana.setGenero(analista.getGenero());
		ana.setLocalidad(analista.getLocalidad());
		ana.setMail(analista.getMail());
		ana.setMailInstitucional(analista.getMailInstitucional());
		ana.setFechaNac(analista.getFechaNac());
		ana.setContrasenia(analista.getContrasenia());
		ana.setItr(analista.getItr());
		ana.setEstadoUsuario(analista.getEstadoUsuario());
		ana.setTipoUsuario(analista.getTipoUsuario());
		if (ana != null) {
			em.flush();
		} else {
			System.out.println("No se encontro el analista");
		}
	} catch (PersistenceException e) {
		throw new ServiciosException("No se pudo modificar el analista");
	}
}

	@Override
	public Analista obtenerPorIdAnalista(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Analista obtenerPorNombreAnalista(String nombre) throws ServiciosException {
		// TODO Auto-generated method stub
		return null;
	}}
		
	

//	@Override
//	public Analista obtenerPorIdAnalista(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Analista obtenerPorNombreAnalista(String nombre) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
