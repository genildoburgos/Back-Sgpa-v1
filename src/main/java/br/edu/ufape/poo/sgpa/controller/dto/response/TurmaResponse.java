package br.edu.ufape.poo.sgpa.controller.dto.response;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

public class TurmaResponse {
	private Long id;
	private Instrutor instrutor;
	private List<Matricula> matriculas;
	private Modalidade modalidade;
	private Sala sala;
	private Vaga vaga;
	
	public TurmaResponse() {}

	public TurmaResponse(Turma turma) {
		this.id = turma.getId();
		this.instrutor = turma.getInstrutor();
		this.matriculas = turma.getMatriculas();
		this.modalidade = turma.getModalidade();
		this.sala = turma.getSala();
		this.vaga = turma.getVaga();
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public Sala getSala() {
		return sala;
	}

	public Vaga getVaga() {
		return vaga;
	}

}
