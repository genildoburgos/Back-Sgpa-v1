package br.edu.ufape.poo.sgpa.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements IPessoa {
	private String nome;
    private String cpf;
    private String sexo;
    private LocalDate dataDeNascimento;
    private String telefone;
    private String contatoDeEmergencia;
    private String email;
    private int idade;

    @OneToOne
    private Endereco endereco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.contatoDeEmergencia = contatoDeEmergencia;
        this.email = email;
        this.idade = idade;
    }
    
    @Override
    public boolean validarCPF(String cpf) {
    	
    	// Este método valida um CPF.
        // 1. Remove todos os caracteres não numéricos do CPF.
        // 2. Verifica se o CPF tem exatamente 11 dígitos.
        // 3. Verifica se o CPF não é uma sequência repetida (ex: 111.111.111-11).
        // 4. Calcula os dois dígitos verificadores usando os primeiros 9 dígitos.
        // 5. Compara os dígitos verificadores calculados com os dígitos do CPF fornecido.
        // Retorna true se o CPF for válido, e false caso contrário.
        // Autor: Analice Silva.
    	
		cpf = cpf.replaceAll("\\D", "");

		if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		try {
			int primeiroDigito = calcularDigitoVerificador(cpf.substring(0, 9), 10);
			int segundoDigito = calcularDigitoVerificador(cpf.substring(0, 9) + primeiroDigito, 11);
			return cpf.equals(cpf.substring(0, 9) + primeiroDigito + segundoDigito);
		} catch (NumberFormatException e) {
			return false;
		}
	}

    @Override
	public int calcularDigitoVerificador(String base, int pesoInicial) {
    	
    	// Este método calcula um dígito verificador para um CPF.
        // 1. Recebe uma sequência de 9 dígitos (base) e um peso inicial.
        // 2. Realiza a soma ponderada dos dígitos, multiplicando cada um pelo peso correspondente.
        // 3. Calcula o resto da divisão da soma por 11.
        // 4. Retorna o dígito verificador: se o resto for menor que 2, retorna 0; caso contrário, retorna 11 menos o resto.
        // Autor: Analice Silva.
    	
		int soma = 0;
		for (int i = 0; i < base.length(); i++) {
			int digito = Integer.parseInt(base.substring(i, i + 1));
			soma += digito * pesoInicial--;
		}
		int resto = soma % 11;
		return (resto < 2) ? 0 : 11 - resto;
	}

	@Override
	public boolean checarTelefone(String telefone) throws TelefoneInvalidoException {
		
		// Verifica se o telefone tem exatamente 10 dígitos.
	    // Lança uma exceção se o telefone não for válido.
	    // Autor: Analice Silva.
		
		if (telefone.length() > 10 || telefone.length() < 10) {
			throw new TelefoneInvalidoException();
		} else {
			return true;
		}
	}
	
	public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContatoDeEmergencia() {
        return this.contatoDeEmergencia;
    }

    public void setContatoDeEmergencia(String contatoDeEmergencia) {
        this.contatoDeEmergencia = contatoDeEmergencia;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", email='" + email + '\'' +
                ", contatoDeEmergencia='" + contatoDeEmergencia + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", sexo='" + sexo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getSexo(), pessoa.getSexo()) && Objects.equals(getDataDeNascimento(), pessoa.getDataDeNascimento()) && Objects.equals(getTelefone(), pessoa.getTelefone()) && Objects.equals(getContatoDeEmergencia(), pessoa.getContatoDeEmergencia()) && Objects.equals(getEmail(), pessoa.getEmail()) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(getId(), pessoa.getId()) && Objects.equals(getIdade(), pessoa.getIdade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf(), getSexo(), getDataDeNascimento(), getTelefone(), getContatoDeEmergencia(), getEmail(), endereco, getId(), getIdade());
    }
}

