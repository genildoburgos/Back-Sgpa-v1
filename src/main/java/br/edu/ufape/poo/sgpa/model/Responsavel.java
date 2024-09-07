package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="responsavel", schema="academia")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="parentesco")
    private String parentesco;
    @Column(name="telefone")
    private String telefone;

    public Responsavel() {
    }

    public Responsavel(String parentesco, String telefone) {
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

    @Override
    public String toString() {
        return "Responsavel{" +
                "id=" + id +
                ", parentesco='" + parentesco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Responsavel that)) return false;
        return getId() == that.getId() && Objects.equals(getParentesco(), that.getParentesco()) && Objects.equals(getTelefone(), that.getTelefone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParentesco(), getTelefone());
    }
}
