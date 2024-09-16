package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.Plano;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.Periodicidade;


public class PlanoRequest {
    
    private double valor;
    private String dataDeVencimento;
    private Periodicidade periodicidade;
    private Unidade unidade;

    public PlanoRequest(){}

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

    public Plano toPlano() {
        Plano plano = new Plano();
      
        plano.setValor(this.valor);
        plano.setDataDeVencimento(this.dataDeVencimento);
        plano.setPeriodicidade(this.periodicidade);
        plano.setUnidade(this.unidade);

        return plano;
    }

}
