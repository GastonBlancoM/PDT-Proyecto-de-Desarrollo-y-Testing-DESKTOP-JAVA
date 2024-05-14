package com.servicios;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.Convocatoria_AsistenciaDTO;
import com.entities.Convocatoria_Asistencia;
import com.exception.ServiciosException;

public class ConvocatoriaBeanImp implements ConvocatoriaBeanCliente {
	private Convocatoria_AsistenciaBeanRemote convocatoriaBean;
	
	@Override
	public void crearConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria) throws ServiciosException {
		try {
			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoriaBean.crearConvocatoria_Asistencia(convocatoria);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void borrarConvocatoria_Asistencia(Long id) throws ServiciosException {
		try {
			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoriaBean.borrarConvocatoria_Asistencia(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public List<Convocatoria_Asistencia> obtenerTodosConvocatoria_Asistencia() throws ServiciosException {
		try {
			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			return convocatoriaBean.obtenerTodosConvocatoria_Asistencias();
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());
		}

	}

	@Override
	public void modificarConvocatoria_Asistencia(Convocatoria_AsistenciaDTO convocatoria) throws ServiciosException {
		try {
			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			convocatoriaBean.modificarConvocatoria_Asistencia(convocatoria);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

	@Override
	public Convocatoria_Asistencia obtenerPorIdConvocatoria_Asistencia(Long id) throws ServiciosException {
		try {
			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
			return convocatoriaBean.obtenerPorIdConvocatoria_Asistencia(id);
		} catch (NamingException e) {
			throw new ServiciosException(e.getMessage());

		}

	}

//	@Override
//	public Convocatoria_Asistencia obtenerPorNombreConvocatoria_Asistencia(String nombre) throws ServiciosException {
//		try {
//			convocatoriaBean = (UsuarioBeanRemote) InitialContext
//					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
//			return convocatoriaBean.obtenerPorNombreUsuario(nombre);
//		} catch (NamingException e) {
//			throw new ServiciosException(e.getMessage());
//
//		}
//	}

//	@Override
//	public List<Convocatoria_Asistencia> buscarPorTipoAsistencia(TipoAsistencia asistencia) throws ServiciosException {
//		try {
//			convocatoriaBean = (Convocatoria_AsistenciaBeanRemote) InitialContext
//					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
//			return convocatoriaBean.;
//		} catch (NamingException e) {
//			throw new ServiciosException(e.getMessage());
//
//		}
//
//	}

//	@Override
//	public List<Usuario> obtenerPorFiltros(TipoUsuario tipoUsuario, ITR itr, EstadoUsuario estado)
//			throws ServiciosException {
//		try {
//			usuarioBean = (UsuarioBeanRemote) InitialContext
//					.doLookup("ejb:/PDT-EJB-GITHUB/Convocatoria_AsistenciaBean!com.servicios.Convocatoria_AsistenciaBeanRemote");
//			return usuarioBean.obtenerPorFiltros(tipoUsuario, itr, estado);
//		} catch (NamingException e) {
//			throw new ServiciosException(e.getMessage());
//
//		}
//
//	}
}
