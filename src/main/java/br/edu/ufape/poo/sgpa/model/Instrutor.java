package br.edu.ufape.poo.sgpa.model;

import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instrutor extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String clt;

    @ManyToMany
    private List<SlotHorario> horariosDeTrabalho;


    @ElementCollection(targetClass = Modalidade.class) // Indica que é uma coleção de elementos simples
    @Enumerated(EnumType.STRING) // Armazena como String no banco de dados
    private List<Modalidade> modalidades;
    @ManyToMany
    private List<Unidade> unidades;


    public Instrutor() {
        super();
    }

    public Instrutor(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email, List<Unidade> unidades, List<Modalidade> modalidades, List<SlotHorario> horariosDeTrabalho, String clt, int idade) {
        super(nome, cpf, sexo, dataDeNascimento, telefone, contatoDeEmergencia, email, idade);
        this.unidades = unidades;
        this.modalidades = modalidades;
        this.horariosDeTrabalho = horariosDeTrabalho;
        this.clt = clt;
    }

    public Instrutor(Pessoa pessoa, List<Unidade> unidades, List<Modalidade> modalidades, List<SlotHorario> horariosDeTrabalho, String clt) {
        super(pessoa.getNome(), pessoa.getCpf(), pessoa.getSexo(), pessoa.getDataDeNascimento(), pessoa.getTelefone(), pessoa.getContatoDeEmergencia(), pessoa.getEmail(), pessoa.getIdade());
        this.unidades = unidades;
        this.modalidades = modalidades;
        this.horariosDeTrabalho = horariosDeTrabalho;
        this.clt = clt;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return super.toString() + // Chama o toString() da superclasse
                ", Instrutor{" +
                "unidades=" + unidades +
                ", modalidades=" + modalidades +
                ", horariosDeTrabalho=" + horariosDeTrabalho +
                ", clt='" + clt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrutor instrutor)) return false;
        if (!super.equals(o)) return false;
        return getId() == instrutor.getId() && Objects.equals(getClt(), instrutor.getClt()) && Objects.equals(getHorariosDeTrabalho(), instrutor.getHorariosDeTrabalho()) && Objects.equals(getModalidades(), instrutor.getModalidades()) && Objects.equals(getUnidades(), instrutor.getUnidades());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getClt(), getHorariosDeTrabalho(), getModalidades(), getUnidades());
    }
}
