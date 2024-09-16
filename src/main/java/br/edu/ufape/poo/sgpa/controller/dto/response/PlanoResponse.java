package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Plano;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.Periodicidade;

public class PlanoResponse {
    private Long id;
    private double valor;
    private String dataDeVencimento;
    private Periodicidade periodicidade;
    private Unidade unidade;

    public PlanoResponse(){

    }

    public Long getId() {
        return id;
    }

    public PlanoResponse(Plano plano) {
        this.id = plano.getId();
        this.valor = plano.getValor();
        this.dataDeVencimento = plano.getDataDeVencimento();
        this.periodicidade = plano.getPeriodicidade();
        this.unidade = plano.getUnidade();
    }

    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

    public String getDataDeVencimento(){
        return dataDeVencimento;
    }
    public void setDataDeVencimento(String dataDeVencimento){
        this.dataDeVencimento = dataDeVencimento;
    }

    public Periodicidade getPeriodicidade(){
        return periodicidade;
    }
    public void setDataDeVencimento(Periodicidade periodicidade){
        this.periodicidade = periodicidade;
    }

    public Unidade getUnidade(){
        return unidade;
    }
    public void setUnidade(Unidade unidade){
        this.unidade = unidade;
    }

}
