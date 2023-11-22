package gestion.academia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.academia.mappers.EstudianteMappers;
import gestion.academia.model.EstudianteDTO;
import gestion.academia.persitence.entities.CursoEntity;
import gestion.academia.persitence.entities.EstudianteEntity;
import gestion.academia.persitence.repositories.CursoRepository;
import gestion.academia.persitence.repositories.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteRepository estudianteRepository;

	@Autowired
	EstudianteMappers estudianteMappers;
	
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {

		EstudianteEntity esE = estudianteRepository
				.save(estudianteMappers.mapEstudianteDTOtoEstudianteEntity(estudianteDTO));

		return estudianteMappers.mapEstudianteEntitytoEstudianteDTO(esE);
	}
	
	@Override
	public EstudianteDTO crearEstudianteConCurso(EstudianteDTO estudianteDTO) {
		EstudianteEntity estEntity = estudianteMappers.mapEstudianteDTOtoEstudianteEntity(estudianteDTO);
		//CursoEntity cursoEn = cursoRepository.findById(estudianteDTO.getCursoId()).orElseThrow(()-> new RuntimeException("El curson no existe"));
		
		Optional<CursoEntity> optionalCursoEn = cursoRepository.findById(estudianteDTO.getCursoId());
		
		if(optionalCursoEn.isPresent()) {
			estEntity.setCurso(optionalCursoEn.get());
			
		}
		
		estEntity = estudianteRepository.save(estEntity);
		
		return estudianteMappers.mapEstudianteEntitytoEstudianteDTO(estEntity);
	}

	@Override
	public EstudianteDTO inscribirEstudianteACurso(Long estuidanteId, Long cursoId) {
		EstudianteEntity estudienteE = new EstudianteEntity();
		
		Optional<EstudianteEntity> estudienteOptional = estudianteRepository.findById(estuidanteId);
		
		Optional<CursoEntity> cursoOptinal = cursoRepository.findById(cursoId);
		
		if(estudienteOptional.isPresent()) {
			estudienteE = estudienteOptional.get();
			
			if(cursoOptinal.isPresent()) {
				estudienteE.setCurso(cursoOptinal.get());
			}
		}
		
		estudienteE = estudianteRepository.save(estudienteE);
		return estudianteMappers.mapEstudianteEntitytoEstudianteDTO(estudienteE);
	}



}
