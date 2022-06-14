package io.javabrains.springbootstarter.turma;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.javabrains.springbootstarter.aluno.Aluno;
import io.javabrains.springbootstarter.disciplina.Disciplina;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue
	public int codigo;
	@ManyToOne
	public Disciplina disciplina;
	@ElementCollection
	@Temporal(TemporalType.TIME)
	public List<Date> horarios;
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          })
	public List<Aluno> alunos;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Date> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Date> horarios) {
		this.horarios = horarios;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.getTurmas().add(this);
	}
	
	public void removeAluno(int matricula) {
		Aluno aluno = this.alunos.stream().filter(a -> a.getMatricula() == matricula).findFirst().orElse(null);
		if (aluno != null) {
			this.alunos.remove(aluno);
			aluno.getTurmas().remove(this);
		}
	}
	
	public Turma() {
	}
	

}
