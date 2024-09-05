package br.edu.ufape.poo.sgpa.model;

import java.time.LocalDate;

public class Matricula {
	private LocalDate dataDeMatricula;
	private LocalDate dataDeExpiracao;
	
	public Matricula(LocalDate dataDeMatricula, LocalDate dataDeExpiracao) {
		this.dataDeMatricula = dataDeMatricula;
		this.dataDeExpiracao = dataDeExpiracao;
	}
	
	public void ativarMatricula() {
		//falta enum de status
	}
	
	public void suspenderMatricula() {
		//falta enum de status
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
	

}
