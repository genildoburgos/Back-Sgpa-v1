package br.edu.ufape.poo.sgpa.exception;

public class MembroNaoExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MembroNaoExisteException() {
		super("O membro não está cadastrado no sistema");
	}

}