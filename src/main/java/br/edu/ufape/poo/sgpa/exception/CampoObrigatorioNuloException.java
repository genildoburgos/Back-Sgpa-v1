package br.edu.ufape.poo.sgpa.exception;

public class CampoObrigatorioNuloException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CampoObrigatorioNuloException() {
		super("Existe campos obrigatórios que não foram preenchidos");
	}
	
}
