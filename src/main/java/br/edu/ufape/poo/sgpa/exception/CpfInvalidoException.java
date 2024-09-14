package br.edu.ufape.poo.sgpa.exception;

public class CpfInvalidoException extends Exception{
	
	private static final long serialVersionUID = 1L;
    
    public CpfInvalidoException() {
        super("O CPF informado é invalido");
    }
    
}
