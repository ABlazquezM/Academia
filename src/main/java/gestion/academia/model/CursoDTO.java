package gestion.academia.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

	
	private Long cursoId;
	
	private String nombre;
	private String codigoCurso;
	private String descripcion;

	private List<EstudianteDTO> estudiantes;
}
