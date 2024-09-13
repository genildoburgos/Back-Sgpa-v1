package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.Vaga;

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

    public Vaga toVaga() {
        Vaga vaga = new Vaga();
        // Supondo que Vaga tenha os mesmos atributos de VagaRequest
        vaga.setCapacidade(this.capacidade);
        vaga.setQuantidade(this.quantidade);
        // Se necessário, setar o id também (se estiver sendo utilizado)
        
        return vaga;

    }
}
