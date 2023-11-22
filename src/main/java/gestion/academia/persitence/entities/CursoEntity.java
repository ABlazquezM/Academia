package gestion.academia.persitence.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType. SEQUENCE)
	private Long cursoId;

	private String nombre;
	private String codigoCurso;
	private String descripcion;

	@OneToMany(mappedBy = "curso")
	//Se debe poner el mismo nombre que tiene el mnayToOne en el atributo
	private List<EstudianteEntity> estudiantes = new ArrayList<>();
}
