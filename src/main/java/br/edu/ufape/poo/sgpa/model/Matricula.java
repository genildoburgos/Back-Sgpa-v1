package br.edu.ufape.poo.sgpa.model;

import java.time.LocalDate;

import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;

public class Matricula {
	private LocalDate dataDeMatricula;
	private LocalDate dataDeExpiracao;
	private StatusDaMatricula statusDaMatricula;
	
	public Matricula(LocalDate dataDeMatricula, LocalDate dataDeExpiracao) {
		this.dataDeMatricula = dataDeMatricula;
		this.dataDeExpiracao = dataDeExpiracao;
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
	}
	
	public void ativarMatricula() {
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
	}
	
	public void suspenderMatricula() {
		this.statusDaMatricula = StatusDaMatricula.SUSPENSA;
	}

	public LocalDate getDataDeMatricula() {
		return dataDeMatricula;
	}

	public void setDataDeMatricula(LocalDate dataDeMatricula) {
		this.dataDeMatricula = dataDeMatricula;
	}

	public LocalDate getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(LocalDate dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public StatusDaMatricula getStatusDaMatricula() {
		return statusDaMatricula;
	}

	public void setStatusDaMatricula(StatusDaMatricula statusDaMatricula) {
		this.statusDaMatricula = statusDaMatricula;
	}

}
