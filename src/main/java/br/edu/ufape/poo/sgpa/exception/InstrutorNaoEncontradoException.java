package br.edu.ufape.poo.sgpa.exception;

public class InstrutorNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstrutorNaoEncontradoException() {
		super("Instrutor não encontrado.");
	}
}
