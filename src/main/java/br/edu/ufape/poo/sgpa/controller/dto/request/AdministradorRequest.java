package br.edu.ufape.poo.sgpa.controller.dto.request;

import java.time.LocalDate;

import br.edu.ufape.poo.sgpa.model.Unidade;
import jakarta.validation.constraints.NotNull;

public class AdministradorRequest {
    
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String sexo;
    @NotNull
    private LocalDate dataDeNascimento;
    @NotNull
    private String telefone;
    @NotNull
    private String contatoDeEmergencia;
    @NotNull
    private String email;
    @NotNull
    private Unidade unidade;


    public AdministradorRequest(){

    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public LocalDate getDataDeNascimento(){
        return dataDeNascimento;
    }
    public void setDataDeNascimento(LocalDate dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getContatoDeEmergencia(){
        return contatoDeEmergencia;
    }
    public void setContatoDeEmergencia(String contatoDeEmergencia){
        this.contatoDeEmergencia = contatoDeEmergencia;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public Unidade getUnidade(){
        return unidade;
    }
    public void setUnidade(Unidade unidade){
        this.unidade= unidade;
    }
}
