package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import jakarta.validation.constraints.NotNull;

public class TurmaRequest {
	

	private Instrutor instrutor;

	private List<Matricula> matriculas;
	@NotNull
	private Modalidade modalidade;
	@NotNull
	private Sala sala;
	@NotNull
	private Vaga vaga;
	
	public TurmaRequest() {}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public Turma toTurma() {
		Turma turma = new Turma();
		
		turma.setInstrutor(this.instrutor);
		turma.setMatriculas(this.matriculas);
		turma.setModalidade(this.modalidade);
		turma.setSala(this.sala);
		turma.setVaga(this.vaga);
		
		return turma;
		
	}
}