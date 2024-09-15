package br.edu.ufape.poo.sgpa.exception;

public class TurmaNaoExisteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TurmaNaoExisteException() {
		super("A turma não está cadastrado no sistema");
	}

}
