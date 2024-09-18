package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.SlotHorario;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

import java.time.LocalDate;
import java.util.List;

// TODO: Criar DTO para Pessoa e colocar herança
public class InstrutorRequest extends PessoaRequest {
    private String clt;
    private List<SlotHorario> horariosDeTrabalho;
    private List<Modalidade> modalidades;
    private List<Unidade> unidades;

    public InstrutorRequest() {
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

    public Instrutor toInstrutor(){
        Instrutor instrutor = new Instrutor();

        instrutor.setClt(this.clt);
        instrutor.setHorariosDeTrabalho(this.horariosDeTrabalho);
        instrutor.setModalidades(this.modalidades);
        instrutor.setUnidades(this.unidades);
        instrutor.setContatoDeEmergencia(this.getContatoDeEmergencia());
        instrutor.setCpf(this.getCpf());
        instrutor.setDataDeNascimento(this.getDataDeNascimento());
        instrutor.setEmail(this.getEmail());
        instrutor.setIdade(this.getIdade());
        instrutor.setNome(this.getNome());
        instrutor.setSexo(this.getSexo());
        instrutor.setTelefone(this.getTelefone());
        
        return instrutor;
        
    }
}