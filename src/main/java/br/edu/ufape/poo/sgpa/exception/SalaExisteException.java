package br.edu.ufape.poo.sgpa.exception;

public class SalaExisteException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public SalaExisteException() {
		super("Existe no sistema uma sala com o bloco e número informados");
	}

}