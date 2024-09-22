package br.edu.ufape.poo.sgpa.exception;

public class TurmaComMembrosException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public TurmaComMembrosException() {
		super("A turma não pode ser removida porque há membros matriculados.");
	}
}
