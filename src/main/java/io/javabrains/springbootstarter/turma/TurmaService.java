/*
package io.javabrains.springbootstarter.turma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.javabrains.springbootstarter.aluno.Aluno;
import io.javabrains.springbootstarter.aluno.AlunoService;

@Service
public class TurmaService {
	
	private List<Turma> turmas = new ArrayList<Turma>();
	@Autowired
	private AlunoService alunoservice = new AlunoService();
	
	private Aluno aluno1 = alunoservice.getAlunoById(1);
	private Aluno aluno2 = alunoservice.getAlunoById(2);
	private Aluno aluno3 = alunoservice.getAlunoById(3);
	private Aluno aluno4 = alunoservice.getAlunoById(4);
	private Aluno aluno5 = alunoservice.getAlunoById(5);
	
	public TurmaService() {
		turmas.addAll(Arrays.asList(
				new Turma(1, "Banco de Dados", 3, Arrays.asList(aluno1, aluno2)),
				new Turma(2, "Arquitetura de Computadores", 2, Arrays.asList(aluno2, aluno3)),
				new Turma(3, "Projeto Integrador", 4, Arrays.asList(aluno3, aluno4)),
				new Turma(4, "Matemática Discreta", 2, Arrays.asList(aluno4, aluno5))
				));
	}
	
	public Turma getTurma(int codigo) {
		for (Turma turma : turmas) {
			if(turma.getCodigo() == codigo){
				return turma;
			}
		}
		return null;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void addTurmas(Turma turma) {
		turmas.add(turma);
	}
	
	public Turma updateTurma(int codigo, Turma turmaUp) {
		turmas
		.stream()
		.forEach(turma -> {
			if(turma.getCodigo() == codigo) {
				turma.setDisciplina(turmaUp.getDisciplina());
				turma.setSemestre(turmaUp.getSemestre());
				turma.setCodigo(turmaUp.getCodigo());
			}
		});
	return turmas
			.stream()
			.filter(turma -> turma.getCodigo() == codigo)
			.findFirst()
			.get();
	}
	
	public void deleteTurma(int codigo) {
		turmas
		.stream()
		.forEach(turma -> {
			if(turma.getCodigo() == codigo) {
				turmas.remove(turmas.indexOf(turma));
			}
		});
	}
	
	public List<Aluno> getAlunos(int codigo) {
		for (Turma turma : turmas) {
			if(turma.getCodigo() == codigo){
				return turma.getAlunos();
			}
		}
		return null;
	}
	
	public void addAluno(int codigo,Aluno aluno) {
		turmas
			.stream()
			.forEach(turma -> {
				if(turma.getAlunos() == null) {
					turma.alunos = new ArrayList<Aluno>();
				}
				if(turma.getCodigo() == codigo) {
					List<Aluno> newaluno = new ArrayList<Aluno>(turma.getAlunos());
					newaluno.add(aluno);
					turma.setAlunos(newaluno);
				}
			});
	}
	
	public Boolean deleteAluno(int codigo,int matricula) {
		for (Turma turma2 : turmas) {
			if(turma2.getCodigo() == codigo){
				List<Aluno> aluno = new ArrayList<Aluno>(turma2.getAlunos()); 
				Aluno aluno1 = aluno.stream().filter(a -> a.getMatricula() == matricula).findFirst().get();
						aluno.remove(aluno1);
						turma2.setAlunos(aluno);
						return true;
			}
		}
		return false;
	}

}
*/