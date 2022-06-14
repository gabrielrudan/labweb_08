package io.javabrains.springbootstarter.turma;


import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
	@ManyToMany
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

	public void setSemestre(List<Date> horarios) {
		this.horarios = horarios;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public Turma() {
	}
	

}
