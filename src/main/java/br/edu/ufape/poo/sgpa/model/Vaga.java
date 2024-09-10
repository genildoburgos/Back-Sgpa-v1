package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table ( name = "vagas", schema = "academia")
public class Vagas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="capacidade")
    private int capacidade;
    @Column(name="quantidade")
    private int quantidade;

    public Vagas(int capacidade, int quantidade) {
        this.capacidade = capacidade;
        this.quantidade = quantidade;
    }

    public Vagas() {

    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Vagas{" +
                "capacidade=" + capacidade +
                ", id=" + id +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vagas vagas)) return false;
        return getId() == vagas.getId() && getCapacidade() == vagas.getCapacidade() && getQuantidade() == vagas.getQuantidade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCapacidade(), getQuantidade());
    }

}