package gestion.academia.service;

import gestion.academia.model.CursoDTO;

public interface CursoService {
	
	CursoDTO crearCurso(CursoDTO cursoDTO);
	
	CursoDTO obtenerCurso(Long cursoId);

}
