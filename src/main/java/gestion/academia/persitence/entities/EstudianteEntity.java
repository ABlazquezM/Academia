package gestion.academia.persitence.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EstudianteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	
	
	@ManyToOne //Cada estudiante solo puede estar en un curso
	@JoinColumn(name = "curso_id") //SQL no sabe camelCase, si tiene dos palabras debemos separarlas con _ y en minusculas
	//El join se hace en el manytoOne
	//En mi tabla se va a crear el campo curso_id
	//Es el mimo nombre que tiene el atrubuto en la otra entidad, con la que se enlaza
	private CursoEntity curso;
	//En el service le estamos pasando un curso
	

	// Constructor, getters y setters

}
