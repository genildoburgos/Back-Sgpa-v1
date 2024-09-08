package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;


@Entity
@Table( name="unidade", schema="academia")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "contato")
    private String contato;
    @Column(name = "horario_de_funcionamento")
    private String horarioDeFuncionamento;
    @Column(name = "email")
    private String email;

    /*@ManyToMany
    @JoinColumn(name= "instrutor_id")
    private Instrutor instrutor;*/

    @OneToMany
    @JoinColumn(name ="plano_id")
    private List<Plano> plano;

    @JoinColumn(name ="segmento")
    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    @OneToOne
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name="membro_id")
    private Membro membro;

    
    @ManyToOne
    @JoinColumn(name="administrador_id")
    private Administrador administrador;
    
    @ManyToOne
    @JoinColumn(name="turma_id")
    private Turma turma;

    @OneToMany
    @JoinColumn(name="sala_id")
    private List<Sala> sala;

    public Unidade(){

    }

    public Unidade(String nome, String cnpj, String contato, String horarioDeFuncionamento, String email,/*Instrutor instrutor */ List<Plano> plano, Segmento segmento, Endereco endereco, Membro membro, Turma turma,/*Administrador administrador */ List<Sala> sala){
        this.nome = nome;
        this.cnpj= cnpj;
        this.contato = contato;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.email = email;
        /*this.instrutor = instrutor; */
        this.plano = plano;
        this.segmento = segmento;
        this.endereco = endereco;
        this.membro = membro;
        this.turma = turma;
        /*this.administrador = administrador; */
        this.sala = sala;

    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getContato(){
        return contato;
    }
    public void setContato(String contato){
        this.contato = contato;
    }

    public String getHorarioDeFuncionamento(){
        return horarioDeFuncionamento;
    }
    public void setHorarioDeFuncionamento(String horarioDeFuncionamento){
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    /*public Instrutor getInstrutor(){
     return instrutor;
     }
      public void setInstrutor(Instrutor instrutor){
     this.instrutor = instrutor;
     }
    */
    public List<Plano> getPlano(){
        return plano;
    }
    public void setPlano(List<Plano> plano){
        this.plano = plano;
    }

    public Endereco getEndereco(){
        return endereco;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Segmento getSegmento(){
        return segmento;
    }
    public void setSegmento(Segmento segmento){
        this.segmento = segmento;
    }

    public Membro getMembro(){
        return membro;
    }
    public void seMembro(Membro membro){
        this.membro = membro;
    }

    public Turma getTurma(){
        return turma;
    }
    public void settTurma(Turma turma){
        this.turma = turma;
    }

    public Administrador getAdministrador(){
      return administrador;
    }
     public void setAdministrador(Administrador administrador){
     this.administrador = administrador;
     }

     public List<Sala> getSala(){
        return sala;
     }
     public void setSala(List<Sala> sala){
        this.sala = sala;
     }

    @Override
    public String toString() {
        return "Unidade{" +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", contato='" + contato + '\'' +
                ", horarioDeFuncionamento='" + horarioDeFuncionamento + '\'' +
                ", email='" + email + '\'' +/*
                ", instrutor=" + instrutor + */
                ", plano=" + plano +
                ", segmentos=" + segmento +
                ", endereco=" + endereco +
                ", membros=" + membro +
                ", turmas=" + turma +/* 
                ", administrador=" + administrador +*/
                ", salas=" + sala +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unidade unidade)) return false;
        return Objects.equals(getId(), unidade.getId()) &&
               Objects.equals(getNome(), unidade.getNome()) &&
               Objects.equals(getCnpj(), unidade.getCnpj()) &&
               Objects.equals(getContato(), unidade.getContato()) &&
               Objects.equals(getHorarioDeFuncionamento(), unidade.getHorarioDeFuncionamento()) &&
               Objects.equals(getEmail(), unidade.getEmail()) &&
               /*Onjects.equals(getInstrutor(), unidade.getInstrutor()) && */
               Objects.equals(getPlano(), unidade.getPlano()) &&
               Objects.equals(getSegmento(), unidade.getSegmento()) &&
               Objects.equals(getEndereco(), unidade.getEndereco()) &&
               Objects.equals(getMembro(), unidade.getMembro()) &&
               Objects.equals(getTurma(), unidade.getTurma()) &&
               /*Objects.equals(getAdministrador(), unidade.getAdministrador()) && */
               Objects.equals(getSala(), unidade.getSala());
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCnpj(), getContato(), getHorarioDeFuncionamento(), getEmail(),/*getInstrutor(), */ getPlano(), getSegmento(), getEndereco(), getMembro(), getTurma(),/*getAdministrador(), */ getSala());
    }
}
