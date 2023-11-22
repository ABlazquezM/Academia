package gestion.academia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {
	
	
	private Long id;
	private String nombre;
	private Long cursoId;
	

	// Constructor, getters y setters

}
