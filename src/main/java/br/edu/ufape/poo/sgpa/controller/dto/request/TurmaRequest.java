package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import jakarta.validation.constraints.NotNull;

public class TurmaRequest {
	
	@NotNull
	private Instrutor instrutor;
	@NotNull
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
