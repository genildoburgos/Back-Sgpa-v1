package br.edu.ufape.poo.sgpa.controller.dto.response;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Responsavel;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;

public class MembroResponse {
	
	private String numeroDeMatricula;
    private StatusDePagamento statusDePagamento;
    private List<Matricula> matriculas;
    private Responsavel responsavel;
    private List<Turma> turmas;

    public MembroResponse(Membro membro) {
        this.numeroDeMatricula = membro.getNumeroDeMatricula();
        this.statusDePagamento = membro.getStatusDePagamento();
        this.matriculas = membro.getMatriculas();
        this.responsavel = membro.getResponsavel();
        this.turmas = membro.getTurmas();
    }

	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}
	
	public StatusDePagamento getStatusDePagamento() {
		return statusDePagamento;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
}
