package com.servicios;

import java.util.List;
import com.dto.TutorDTO;
import com.dto.UsuarioDTO;
import com.entities.Tutor;
import com.entities.Usuario;
import com.exception.ServiciosException;

public interface TutorBeanCliente {
	void crearTutor(TutorDTO tutor) throws ServiciosException;

	void borrarTutor(Long id) throws ServiciosException;

	void modificarTutor(TutorDTO tutor) throws ServiciosException;

	List<Tutor> obtenerTodosTutores() throws ServiciosException;

	Tutor obtenerPorIdTutor(Long id) throws ServiciosException;

	Tutor obtenerPorNombreTutor(String nombre) throws ServiciosException;
	
	Tutor oBuscaOBusca(Long id) throws ServiciosException;
}
