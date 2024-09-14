package br.edu.ufape.poo.sgpa.exception;

public class TelefoneInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TelefoneInvalidoException() {
		super("Erro ao cadastrar cliente, telefone inválido");
	}

}
