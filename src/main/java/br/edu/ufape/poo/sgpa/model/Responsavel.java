package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String parentesco;
    private String telefone;

    public Responsavel() {
    }

    public Responsavel(String nome, String parentesco, String telefone) {
        this.nome = nome;
        this.parentesco = parentesco;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Responsavel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Responsavel that)) return false;
        return getId() == that.getId() && Objects.equals(getNome(), that.getNome()) && Objects.equals(getParentesco(), that.getParentesco()) && Objects.equals(getTelefone(), that.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getParentesco(), getTelefone());
    }
}
