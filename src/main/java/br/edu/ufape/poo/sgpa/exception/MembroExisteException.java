package br.edu.ufape.poo.sgpa.exception;

public class MembroExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MembroExisteException() {
		super("Existe no sistema um membro com o CPF informado");
	}

}
