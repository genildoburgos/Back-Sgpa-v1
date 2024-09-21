package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.model.SlotHorario;
import java.util.List;

public class SalaResponse {

    private Long id;
    private String bloco;
    private String numero;
    private int capacidade;
    private List<SlotHorario> slotsHorario;

    public SalaResponse(Sala sala) {
        this.id = sala.getId();
        this.bloco = sala.getBloco();
        this.numero = sala.getNumero();
        this.capacidade = sala.getCapacidade();
        this.slotsHorario = sala.getSlotsHorario();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<SlotHorario> getSlotsHorario() {
        return slotsHorario;
    }

    public void setSlotsHorario(List<SlotHorario> slotsHorario) {
        this.slotsHorario = slotsHorario;
    }
}
