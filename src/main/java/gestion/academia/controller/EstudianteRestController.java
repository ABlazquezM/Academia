package gestion.academia.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gestion.academia.model.EstudianteDTO;
import gestion.academia.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteRestController {
	
	
	@Autowired
	EstudianteService estudianteService;
	
	@PostMapping
	ResponseEntity<?> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
		EstudianteDTO est = estudianteService.crearEstudiante(estudianteDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+est.getId()).buildAndExpand(est.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/curso")
	ResponseEntity<?> crearEstudianteConCurso(@RequestBody EstudianteDTO estudianteDTO){
		EstudianteDTO est = estudianteService.crearEstudianteConCurso(estudianteDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+est.getId()).buildAndExpand(est.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/{estuidanteId}/inscripcion/{cursoId}")
	ResponseEntity<?> inscribirEstudianteACurso(@PathVariable Long estuidanteId, @PathVariable Long cursoId){
		EstudianteDTO estudianteDTO =  estudianteService.inscribirEstudianteACurso(estuidanteId, cursoId);
		
		return ResponseEntity.ok(estudianteDTO);
		
	}
}
