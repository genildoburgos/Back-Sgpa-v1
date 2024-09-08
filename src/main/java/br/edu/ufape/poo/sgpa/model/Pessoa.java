package br.edu.ufape.poo.sgpa.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name="pessoa", schema = "academia" )
public class Pessoa {
    @Column(name="nome")
	private String nome;
    @Column(name="cpf")
    private String cpf;
    @Column(name="sexo")
    private String sexo;
    @Column(name="data_de_nascimento")
    private LocalDate dataDeNascimento;
    @Column(name="telefome")
    private String telefone;
    @Column(name="contato_de_emergencia")
    private String contatoDeEmergencia;
    @Column(name="email")
    private String email;

    @OneToOne
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.contatoDeEmergencia = contatoDeEmergencia;
        this.email = email;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getSexo(), pessoa.getSexo()) && Objects.equals(getDataDeNascimento(), pessoa.getDataDeNascimento()) && Objects.equals(getTelefone(), pessoa.getTelefone()) && Objects.equals(getContatoDeEmergencia(), pessoa.getContatoDeEmergencia()) && Objects.equals(getEmail(), pessoa.getEmail()) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(getId(), pessoa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf(), getSexo(), getDataDeNascimento(), getTelefone(), getContatoDeEmergencia(), getEmail(), endereco, getId());
    }
}

