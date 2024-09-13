package br.edu.ufape.poo.sgpa.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Administrador extends Pessoa {

    @ManyToOne
    private Unidade unidade;

    public Administrador(){

    }

    public Administrador(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email, Unidade unidade) {
        super(nome, cpf, sexo, dataDeNascimento, telefone, contatoDeEmergencia, email);
        this.unidade = unidade;
    }
    public Unidade getUnidade(){
        return unidade;
    }

    public void setUnidade(Unidade unidade){
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Administrador)) return false;
    Administrador administrador = (Administrador) o;
    return Objects.equals(getNome(), administrador.getNome()) &&
           Objects.equals(getCpf(), administrador.getCpf()) &&
           Objects.equals(getSexo(), administrador.getSexo()) &&
           Objects.equals(getDataDeNascimento(), administrador.getDataDeNascimento()) &&
           Objects.equals(getTelefone(), administrador.getTelefone()) &&
           Objects.equals(getContatoDeEmergencia(), administrador.getContatoDeEmergencia()) &&
           Objects.equals(getEmail(), administrador.getEmail()) &&
           Objects.equals(getUnidade(), administrador.getUnidade()) &&
           Objects.equals(getId(), administrador.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unidade);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", sexo='" + getSexo() + '\'' +
                ", dataDeNascimento=" + getDataDeNascimento() +
                ", telefone='" + getTelefone() + '\'' +
                ", contatoDeEmergencia='" + getContatoDeEmergencia() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", unidade=" + unidade +
                "id=" + getId() +
                '}';

                }
}
