package gestion.academia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import gestion.academia.model.EstudianteDTO;
import gestion.academia.persitence.entities.CursoEntity;
import gestion.academia.persitence.entities.EstudianteEntity;

@Mapper(componentModel = "spring")
public interface EstudianteMappers {
	
	@Mapping(source = "curso", target = "cursoId", qualifiedByName = "mapCursoid")
	EstudianteDTO mapEstudianteEntitytoEstudianteDTO(EstudianteEntity estudianteEntity);
	
	
	EstudianteEntity mapEstudianteDTOtoEstudianteEntity(EstudianteDTO estudianteDTO);

	@Named("mapCursoid") //Debe tener el mismo nombre que en el qualifiedByName
	default Long mapCursoid(CursoEntity cursoEntity) {
		if(cursoEntity != null) {
			return cursoEntity.getCursoId();	
		}
		
		return null;
	}
}
//Debemos exlicar como se llama el atributo ne la clase origen y en la clase destiono