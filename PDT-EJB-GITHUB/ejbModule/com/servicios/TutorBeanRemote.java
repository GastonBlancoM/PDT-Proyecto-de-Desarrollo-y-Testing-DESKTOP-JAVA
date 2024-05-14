package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.dto.EstudianteDTO;
import com.dto.TutorDTO;
import com.entities.Estudiante;
import com.entities.Tutor;
import com.exception.ServiciosException;

@Remote
public interface TutorBeanRemote {
	void crearTutor(TutorDTO tutor) throws ServiciosException;

	void borrarTutor(Long id) throws ServiciosException;

	void asignarITRTutor(Long idTutor, Long idITR) throws ServiciosException;

	List<Tutor> obtenerTodosTutores();

	void modificar(TutorDTO tutor) throws ServiciosException;

	Tutor obtenerPorIdTutor(Long id);

	Tutor obtenerPorNombreTutor(String nombre);
	
	Tutor buscarTutor(Long id) throws ServiciosException;

}
