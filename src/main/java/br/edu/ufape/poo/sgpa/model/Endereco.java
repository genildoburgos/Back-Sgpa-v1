package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="endereco", schema = "academia")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rua")
    private String rua;
    @Column(name="numero")
    private String numero;
    @Column(name="complemento")
    private String complemento;
    @Column(name="bairro")
    private String bairro;
    @Column(name="cidade")
    private String cidade;
    @Column(name="estado")
    private String estado;
    @Column(name="cep")
    private String cep;

    @OneToOne(mappedBy = "endereco")
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;

    // Construtor padrão
    public Endereco() {
    }

    // Construtor com todos os campos
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep, Pessoa pessoa) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pessoa = pessoa;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco{" +
               "rua='" + rua + '\'' +
               ", numero='" + numero + '\'' +
               ", complemento='" + complemento + '\'' +
               ", bairro='" + bairro + '\'' +
               ", cidade='" + cidade + '\'' +
               ", estado='" + estado + '\'' +
               ", cep='" + cep + '\'' +
               ", id=" + id +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
