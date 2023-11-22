package gestion.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.academia.model.CursoDTO;
import gestion.academia.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoRestController {
	
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping("/{cursoId}")
	ResponseEntity<?> obtenerCurso(@PathVariable Long cursoId){
		CursoDTO  cursoDTO = cursoService.obtenerCurso(cursoId);
		
		
		if(cursoDTO != null) {
			return ResponseEntity.ok(cursoService.obtenerCurso(cursoId));
		}
		return null;
	}

}
