package br.edu.ufape.poo.sgpa.exception;

public class SalaDuplicadaException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public SalaDuplicadaException() {
		super("Existe no sistema uma sala com o bloco e número informados");
	}

}