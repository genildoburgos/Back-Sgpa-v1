package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int capacidade;
    private int quantidade;

    public Vaga(int capacidade, int quantidade) {
        this.capacidade = capacidade;
        this.quantidade = quantidade;
    }

    public Vaga() {

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
        if (!(o instanceof Vaga vaga)) return false;
        return getId() == vaga.getId() && getCapacidade() == vaga.getCapacidade() && getQuantidade() == vaga.getQuantidade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCapacidade(), getQuantidade());
    }
}