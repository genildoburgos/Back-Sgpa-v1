package br.edu.ufape.poo.sgpa.controller.dto.response;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

public class TurmaResponse {

	private Instrutor instrutor;
	private List<Matricula> matriculas;
	private Modalidade modalidade;
	private Sala sala;
	private Vaga vaga;
	
	public TurmaResponse() {}

	public TurmaResponse(Instrutor instrutor, List<Matricula> matriculas, Modalidade modalidade, Sala sala, Vaga vaga) {
		this.instrutor = instrutor;
		this.matriculas = matriculas;
		this.modalidade = modalidade;
		this.sala = sala;
		this.vaga = vaga;
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
