package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Responsavel;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import jakarta.validation.constraints.NotNull;

public class MembroRequest {
	
	@NotNull
	private String numeroDeMatricula;
	@NotNull
    private StatusDePagamento statusDePagamento;
	@NotNull
    private List<Matricula> matriculas;
	@NotNull
    private Responsavel responsavel;
	@NotNull
    private List<Turma> turmas;
    
    public MembroRequest() {}
    
	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}

	public void setNumeroDeMatricula(String numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}

	public StatusDePagamento getStatusDePagamento() {
		return statusDePagamento;
	}

	public void setStatusDePagamento(StatusDePagamento statusDePagamento) {
		this.statusDePagamento = statusDePagamento;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Membro toMembro() {
		Membro membro = new Membro();
		
		membro.setNumeroDeMatricula(this.numeroDeMatricula);
	    membro.setStatusDePagamento(this.statusDePagamento);
	    membro.setMatriculas(this.matriculas);
	    membro.setResponsavel(this.responsavel);
	    membro.setTurmas(this.turmas);
		
		return membro;
	}
 	
}
