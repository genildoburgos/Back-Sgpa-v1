package br.edu.ufape.poo.sgpa.exception;

public class SalaNaoExisteException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public SalaNaoExisteException() {
		super("A sala não está cadastrada no sistema");
	}

}
