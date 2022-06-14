package io.javabrains.springbootstarter.aluno;

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

@RestController
@RequestMapping("/api/alunos")
public class AlunoRestController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping
	public Iterable<Aluno> getAlunos(){
		return alunoRepository.findAll();
	}
	
	@PostMapping
	public Aluno addAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity <?> getAlunoById(@PathVariable int matricula) {
		return alunoRepository.findById(matricula)
				.map(aluno -> ResponseEntity.ok().body(aluno))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{matricula}")
	public ResponseEntity <?> updateAluno(@PathVariable int matricula, @RequestBody Aluno alunoUp) {
		return alunoRepository.findById(matricula)
				.map(aluno -> {
					aluno.setNome(alunoUp.getNome());
					aluno.setEmail(alunoUp.getEmail());
					aluno.setTelefone(alunoUp.getTelefone());
					aluno.setDataNasc(alunoUp.getDataNasc());
					aluno.setEndereco(alunoUp.getEndereco());
					Aluno updated = alunoRepository.save(aluno);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{matricula}")
	public ResponseEntity <?> deleteAluno(@PathVariable int matricula) {
		return alunoRepository.findById(matricula)
				.map(aluno -> {
					alunoRepository.deleteById(matricula);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}