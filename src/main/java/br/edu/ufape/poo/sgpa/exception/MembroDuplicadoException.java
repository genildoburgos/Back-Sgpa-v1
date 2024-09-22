package br.edu.ufape.poo.sgpa.exception;

public class MembroDuplicadoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MembroDuplicadoException() {
		super("Existe no sistema um membro com o CPF informado");
	}

}
