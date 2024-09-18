package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.util.List;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Responsavel;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import jakarta.validation.constraints.NotNull;

public class MembroRequest extends PessoaRequest {

	@NotNull
	private String numeroDeMatricula;
	private StatusDePagamento statusDePagamento;
	private List<Matricula> matriculas;
	private Responsavel responsavel;
	private List<Turma> turmas;

	public MembroRequest() {
	}

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
		membro.setContatoDeEmergencia(this.numeroDeMatricula);
		membro.setCpf(this.numeroDeMatricula);
		membro.setDataDeNascimento(this.getDataDeNascimento());
		membro.setEmail(this.numeroDeMatricula);
		membro.setIdade(this.getIdade());
		membro.setNome(this.numeroDeMatricula);
		membro.setSexo(this.numeroDeMatricula);
		membro.setTelefone(this.numeroDeMatricula);

		return membro;
	}

}
