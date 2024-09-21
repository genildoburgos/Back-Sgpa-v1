package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.model.SlotHorario;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class SalaRequest {

    @NotNull
    private String bloco;
    @NotNull
    private String numero;
    @NotNull
    private int capacidade;
    private List<SlotHorario> slotsHorario;

    public SalaRequest() {}

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

    public Sala toSala() {
        Sala sala = new Sala();
        sala.setBloco(this.bloco);
        sala.setNumero(this.numero);
        sala.setCapacidade(this.capacidade);
        sala.setSlotsHorario(this.slotsHorario);
        return sala;
    }
}
