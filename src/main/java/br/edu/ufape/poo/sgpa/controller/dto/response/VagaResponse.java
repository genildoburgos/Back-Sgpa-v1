package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Vaga;

public class VagaResponse {
    private long id;
    private int capacidade;
    private int quantidade;

    // Construtor que recebe um objeto do tipo Vagas
    public VagaResponse(Vaga vaga) {
        this.id = vaga.getId();
        this.capacidade = vaga.getCapacidade();
        this.quantidade = vaga.getQuantidade();
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
}
