package br.edu.ufape.poo.sgpa.model;

import br.edu.ufape.poo.sgpa.model.enums.Periodicidade;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Plano implements IPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor;
    private String dataDeVencimento;

    @Enumerated(EnumType.STRING)
    private Periodicidade periodicidade;

    @ManyToOne
    private Unidade unidade;
    
    public Plano(){

    }

    public Plano(double valor, String dataDeVencimento, Periodicidade periodicidade, Unidade unidade){
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.periodicidade = periodicidade;
        this.unidade = unidade;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
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
    public void setPeriodicidade(Periodicidade periodicidade){
        this.periodicidade = periodicidade;
    }

    public Unidade getUnidade(){
        return unidade;
    }
    public void setUnidade(Unidade unidade){
        this.unidade = unidade;
    }

    @Override
    public String toString(){
        return "Plano{"+
                "valor=" + valor +
                ", dataDeVencimento='" + dataDeVencimento + '\'' +
                ", periodicidade=" + periodicidade +
                ", unidade=" + unidade +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Plano plano)) return false;
        return Double.compare(plano.getValor(), getValor()) == 0 &&
                Objects.equals(getId(), plano.getId()) &&
                Objects.equals(getDataDeVencimento(), plano.getDataDeVencimento()) &&
                Objects.equals(getUnidade(), plano.getUnidade()) &&
                getPeriodicidade() == plano.getPeriodicidade();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getValor(), getDataDeVencimento(), getPeriodicidade(), getUnidade());
    }

    @Override
    public Double calcularDesconto(int valor, int porcentagemDesconto) {
        return (double) (valor * porcentagemDesconto);
    }
}
