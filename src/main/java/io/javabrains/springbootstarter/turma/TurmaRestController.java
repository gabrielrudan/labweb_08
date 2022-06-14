package io.javabrains.springbootstarter.turma;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.aluno.AlunoRepository;
import io.javabrains.springbootstarter.disciplina.DisciplinaRepository;

@RestController
@RequestMapping("/api/turmas")
public class TurmaRestController {
	
	@Autowired
	TurmaRepository turmaRepository;
	DisciplinaRepository disciplinaRepository;
	AlunoRepository alunoRepository;
	
	@GetMapping
	Iterable<Turma> getTurmas(){
		return turmaRepository.findAll();
	}
	
	@PostMapping
	Turma addTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity <?> getTurmaById(@PathVariable int codigo) {
		return turmaRepository.findById(codigo)
				.map(turma -> ResponseEntity.ok().body(turma))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity <?> updateTurma(@PathVariable int codigo, @RequestBody Turma turmaUp) {
		return turmaRepository.findById(codigo)
				.map(turma -> {
					turma.setDisciplina(turmaUp.getDisciplina());
					turma.setHorarios(turmaUp.getHorarios());
					Turma updated = turmaRepository.save(turma);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity <?> deleteTurma(@PathVariable int codigo) {
		return turmaRepository.findById(codigo)
				.map(turma -> {
					turmaRepository.deleteById(codigo);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}
