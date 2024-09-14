package br.edu.ufape.poo.sgpa.exception;

public class MembroMenorDeIdadeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MembroMenorDeIdadeException() {
		super("O membro é menor de idade, precisa de um responsável");
	}

}
