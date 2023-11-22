package gestion.academia.service;

import gestion.academia.model.EstudianteDTO;

public interface EstudianteService {
	
	EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);
	
	EstudianteDTO inscribirEstudianteACurso(Long estuidanteId, Long cursoId);
	
	
	EstudianteDTO crearEstudianteConCurso(EstudianteDTO estudianteDTO);

}
