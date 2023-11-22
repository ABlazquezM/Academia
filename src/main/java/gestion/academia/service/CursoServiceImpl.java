package gestion.academia.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import gestion.academia.mappers.CursoMappers;
import gestion.academia.model.CursoDTO;
import gestion.academia.persitence.entities.CursoEntity;
import gestion.academia.persitence.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	CursoMappers cursoMappers;

	@Override
	public CursoDTO crearCurso(CursoDTO cursoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoDTO obtenerCurso(Long cursoId) {
		
		Optional<CursoEntity> cursoEOptional = cursoRepository.findById(cursoId);
		
		
		if(cursoEOptional.isPresent()) {
			return cursoMappers.cursoEntityToCursoDTO(cursoEOptional.get());
		}
		
		return null;
	}

}
