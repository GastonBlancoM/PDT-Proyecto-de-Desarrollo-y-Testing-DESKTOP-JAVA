package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.TypedQuery;

import com.dto.ITRDTO;
import com.dto.UsuarioDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.exception.ServiciosException;

public class ITRBeanImp implements ITRBeanCliente {

	private ITRBeanRemote itrBean;

	public ITR obtenerTodosITRPorNombre(String nombre) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			return itrBean.obtenerPorNombreITR(nombre);

		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<ITR> obtenerTodosITR() throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			return itrBean.obtenerTodosITR();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void crearITR(ITRDTO itr) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			itrBean.crearITR(itr);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarITR(Long id) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			itrBean.borrarITR(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarITR(ITRDTO itr) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			itrBean.modificarITR(itr);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public ITR obtenerPorIdITR(Long id) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			return itrBean.obtenerPorIdITR(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<ITR> buscarPorEstadoITR(EstadoITR estado) throws ServiciosException {
		try {
			itrBean = (ITRBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
			return itrBean.obtenerPorEstadoITR(estado);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

}
