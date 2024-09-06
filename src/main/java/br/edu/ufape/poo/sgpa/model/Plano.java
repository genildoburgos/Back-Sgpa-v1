package br.edu.ufape.poo.sgpa.model;

import br.edu.ufape.poo.sgpa.model.enums.Periodicidade;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="planos", schema ="academia")
public class Plano {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="valor")
    private double valor;
    @Column(name="dataDeVencimento")
    private String dataDeVencimento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Unidade unidade;

    @Enumerated(EnumType.STRING)
    private Periodicidade periodicidade;

    public Plano(){

    }

    public Plano(double valor, String dataDeVencimento, Unidade unidade, Periodicidade periodicidade){
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.unidade = unidade;
        this.periodicidade = periodicidade;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
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

    public Unidade getUnidade(){
        return unidade;
    }
    public void setUnidade(Unidade unidade){
        this.unidade = unidade;
    }

    public Periodicidade getPeriodicidade(){
        return periodicidade;
    }
    public void setPeriodicidade(Periodicidade periodicidade){
        this.periodicidade = periodicidade;
    }

    @Override
    public String toString(){
        return "Plano{"+
                "valor=" + valor +
                ", dataDeVencimento='" + dataDeVencimento + '\'' +
                ", unidade=" + unidade +
                ", periodicidade=" + periodicidade +
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
        return Objects.hash(getId(), getValor(), getDataDeVencimento(), getUnidade(), getPeriodicidade());

    }

}
