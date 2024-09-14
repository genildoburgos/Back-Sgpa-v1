package br.edu.ufape.poo.sgpa.model;

import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;

public interface IPessoa {

	public boolean validarCPF(String cpf);
	public int calcularDigitoVerificador(String base, int pesoInicial);
	public boolean checarTelefone(String telefone) throws TelefoneInvalidoException;
	
}
