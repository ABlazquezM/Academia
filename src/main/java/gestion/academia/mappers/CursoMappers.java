package gestion.academia.mappers;

import org.mapstruct.Mapper;

import gestion.academia.model.CursoDTO;
import gestion.academia.persitence.entities.CursoEntity;

@Mapper(componentModel = "spring", uses = {EstudianteMappers.class})
public interface CursoMappers {

	CursoDTO cursoEntityToCursoDTO(CursoEntity cursoEntity);
	
	CursoEntity cursoDTOToCursoEntity(CursoDTO cursoDTO);
}
