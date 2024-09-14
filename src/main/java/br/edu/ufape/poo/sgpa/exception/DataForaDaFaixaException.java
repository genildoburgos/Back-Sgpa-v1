package br.edu.ufape.poo.sgpa.exception;

public class DataForaDaFaixaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DataForaDaFaixaException() {
		super("Erro ao cadastrar cliente, data inválida");
	}

}
