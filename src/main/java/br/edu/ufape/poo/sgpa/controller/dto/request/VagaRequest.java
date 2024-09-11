package br.edu.ufape.poo.sgpa.controller.dto.request;

public class VagaRequest {
    private int capacidade;
    private int quantidade;

    public VagaRequest(){}

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
