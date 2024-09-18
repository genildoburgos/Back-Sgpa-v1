package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.time.LocalDate;

import br.edu.ufape.poo.sgpa.model.Pessoa;
import jakarta.validation.constraints.NotNull;

public class PessoaRequest {
	
	@NotNull
	private String nome;
	@NotNull
    private String cpf;
	@NotNull
    private String sexo;
	@NotNull
    private LocalDate dataDeNascimento;
	@NotNull
    private String telefone;
	@NotNull
    private String contatoDeEmergencia;
	@NotNull
    private String email;
	@NotNull
    private int idade;
	
	public PessoaRequest() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContatoDeEmergencia() {
		return contatoDeEmergencia;
	}

	public void setContatoDeEmergencia(String contatoDeEmergencia) {
		this.contatoDeEmergencia = contatoDeEmergencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Pessoa toPessoa() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setContatoDeEmergencia(this.contatoDeEmergencia);
		pessoa.setCpf(this.cpf);
		pessoa.setDataDeNascimento(this.dataDeNascimento);
		pessoa.setEmail(this.email);
		pessoa.setIdade(this.idade);
		pessoa.setNome(this.nome);
		pessoa.setNome(this.nome);
		pessoa.setSexo(this.sexo);
		pessoa.setTelefone(this.telefone);
		
		return pessoa;
	}

}




