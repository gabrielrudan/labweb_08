package io.javabrains.springbootstarter.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turmas")
public class TurmaRestController {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@GetMapping
	Iterable<Turma> getTurmas(){
		return turmaRepository.findAll();
	}
	
	@PostMapping
	Turma addTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
/*	@GetMapping("/api/turmas/{codigo}/alunos")
	public List<Aluno> getAlunos(@PathVariable int codigo){
		return turmaService.getAlunos(codigo);
	}
	
	@GetMapping("/api/turmas/{codigo}")
	public Turma getTurmasCodigo(@PathVariable int codigo){
		return turmaService.getTurma(codigo);
	}
	
	@PostMapping("/api/turmas/{codigo}/alunos")
	public void addAluno(@PathVariable int codigo,@RequestBody Aluno aluno) {
		turmaService.addAluno(codigo, aluno);
	}
	
	@PutMapping("/api/turmas/{codigo}")
    public Turma updateTurma(@PathVariable int codigo, @RequestBody Turma turmaUp){
		return turmaService.updateTurma(codigo, turmaUp);
    }

	@DeleteMapping("/api/turmas/{codigo}")
    public void deleteTurma(@PathVariable int codigo){
		turmaService.deleteTurma(codigo);
    }
	
	@DeleteMapping("/api/turmas/{codigo}/alunos/{matricula}")
    public void deleteAluno(@PathVariable int codigo,@PathVariable int matricula){
        if (!turmaService.deleteAluno(codigo,matricula)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
*/	

}
