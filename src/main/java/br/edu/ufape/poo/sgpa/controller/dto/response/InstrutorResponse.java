package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Pessoa;
import br.edu.ufape.poo.sgpa.model.SlotHorario;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

import java.util.List;

public class InstrutorResponse extends PessoaResponse {
    private Long id;
    private String clt;
    private List<SlotHorario> horariosDeTrabalho;
    private List<Modalidade> modalidades;
    private List<Unidade> unidades;

    public InstrutorResponse(Instrutor instrutor) {
        super(instrutor);
        this.id = instrutor.getId();
        this.clt = instrutor.getClt();
        this.horariosDeTrabalho = instrutor.getHorariosDeTrabalho();
        this.modalidades = instrutor.getModalidades();
        this.unidades = instrutor.getUnidades();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public List<SlotHorario> getHorariosDeTrabalho() {
        return horariosDeTrabalho;
    }

    public void setHorariosDeTrabalho(List<SlotHorario> horariosDeTrabalho) {
        this.horariosDeTrabalho = horariosDeTrabalho;
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }
}
