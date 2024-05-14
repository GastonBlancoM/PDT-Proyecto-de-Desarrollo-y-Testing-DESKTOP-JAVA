package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dto.ITRDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.exception.ServiciosException;

@Stateless
public class ITRBean implements ITRBeanRemote {
	@PersistenceContext
    private EntityManager em;

    public ITRBean() {

    }
    @Override
    public void crearITR(ITRDTO itr) throws ServiciosException {
        try {
        	ITR itrs = ITR.builder()
        			.nombre(itr.getNombre())
        			.departamento(itr.getDepartamento())
        			.localidad(itr.getLocalidad())
					.estadoITR(itr.getEstadoITR())
					.build();
            em.persist(itrs);
            em.flush();
        } catch (PersistenceException e) {
            throw new ServiciosException("No se pudo crear el ITR");
        }
    }
    
    @Override
    public void modificarITR(ITRDTO itr) throws ServiciosException {
    	try {
			ITR itrs = em.find(ITR.class, itr.getIdITR());
			itrs.setNombre(itr.getNombre());
			itrs.setDepartamento(itr.getDepartamento());
			itrs.setLocalidad(itr.getLocalidad());
			itrs.setEstadoITR(itr.getEstadoITR());
			
			if (itrs != null) {
				em.flush();
			} else {
				System.out.println("No se encontro el itr");
			}
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el itr");
		}
	}
    
    @Override
    public void borrarITR(Long id) throws ServiciosException {
    		try {
    			ITR itr = em.find(ITR.class, id);
    			em.remove(itr);
    			em.flush();
    		} catch (PersistenceException e) {
    			throw new ServiciosException("No se pudo borrar el ITR");
    		}
    	}
    @Override
    public List<ITR> obtenerTodosITR() {
        TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i", ITR.class);
        return query.getResultList();
    }

	@Override
	public ITR obtenerPorNombreITR(String nom){
		TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i WHERE i.nombre = :nom", ITR.class).setParameter("nom",nom);
		return query.getSingleResult();
	
    }

	@Override
	public ITR obtenerPorIdITR(Long id) {
		TypedQuery<ITR> query = em
				.createQuery("SELECT u FROM ITR u WHERE u.idITR = :id", ITR.class)
				.setParameter("id", id);
		return query.getSingleResult();

	}
	@Override
	public List<ITR> obtenerPorEstadoITR(EstadoITR estado) {
		TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i WHERE i.estadoITR = :estado", ITR.class)
				.setParameter("estado", estado);
		return query.getResultList();
	}
	
	
	}

