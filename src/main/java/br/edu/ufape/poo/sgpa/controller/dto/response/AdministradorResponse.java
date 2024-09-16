package br.edu.ufape.poo.sgpa.controller.dto.response;

import java.time.LocalDate;
import java.util.List;

import br.edu.ufape.poo.sgpa.model.Administrador;
import br.edu.ufape.poo.sgpa.model.Unidade;

public class AdministradorResponse {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String telefone;
    private String contatoDeEmergencia;
    private String email;
    private Unidade unidade;

    public AdministradorResponse(Administrador administrador){
        this.id = administrador.getId();
        this.nome = administrador.getNome();
        this.cpf = administrador.getCpf();
        this.dataDeNascimento = administrador.getDataDeNascimento();
        this.telefone = administrador.getTelefone();
        this.contatoDeEmergencia = administrador.getContatoDeEmergencia();
        this.email = administrador.getEmail();
        this.unidade = administrador.getUnidade();
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome= nome;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
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
        this.unidade = unidade;
    }

    
}
