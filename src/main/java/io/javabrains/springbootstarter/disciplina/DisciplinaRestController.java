package io.javabrains.springbootstarter.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaRestController {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@GetMapping
	Iterable<Disciplina> getDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	@PostMapping
	Disciplina addDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity <?> getDisciplinaById(@PathVariable int codigo) {
		return disciplinaRepository.findById(codigo)
				.map(disciplina -> ResponseEntity.ok().body(disciplina))
				.orElse(ResponseEntity.notFound().build());
	}

}
