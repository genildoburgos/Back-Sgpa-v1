package br.edu.ufape.poo.sgpa.model;

import java.time.LocalDate;
import java.util.Objects;

import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula", schema = "academia")
public class Matricula {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(name="data_de_matricula")
	private LocalDate dataDeMatricula;
	
	@Column(name="data_de_expiracao")
	private LocalDate dataDeExpiracao;
	
	@Enumerated(EnumType.STRING)
	private StatusDaMatricula statusDaMatricula;
	
	//@ManyToOne
    //private Membro membro;
	
	//@ManyToOne
	//private Turma turma; 
	
	public Matricula() {	
	}
	
	public Matricula(LocalDate dataDeMatricula, LocalDate dataDeExpiracao) {
		this.dataDeMatricula = dataDeMatricula;
		this.dataDeExpiracao = dataDeExpiracao;
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
		//this.membro = membro;
		//this.turma = turma;
	}
	
	public void ativarMatricula() {
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
	}
	
	public void suspenderMatricula() {
		this.statusDaMatricula = StatusDaMatricula.SUSPENSA;
	}
	
	public boolean estaExpirada() {
        return LocalDate.now().isAfter(this.dataDeExpiracao);
    }
	
	@Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", dataDeMatricula=" + dataDeMatricula +
                ", dataDeExpiracao=" + dataDeExpiracao +
                ", statusDaMatricula=" + statusDaMatricula +
               // ", membro=" + membro + membro.toString()
               // ", turma=" + turma + turma.toString()
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matricula matricula)) return false;
        return getId() == matricula.getId() &&
               Objects.equals(getDataDeMatricula(), matricula.getDataDeMatricula()) &&
               Objects.equals(getDataDeExpiracao(), matricula.getDataDeExpiracao()) &&
               getStatusDaMatricula() == matricula.getStatusDaMatricula() &&
               Objects.equals(getMembro(), matricula.getMembro()) &&
               Objects.equals(getTurma(), matricula.getTurma());
    }/*

    /*@Override
    public int hashCode() {
        return Objects.hash(getId(), getDataDeMatricula(), getDataDeExpiracao(), getStatusDaMatricula(), getMembro(), getTurma());
    }*/

	public long getId() {
		return id;
	}

	public LocalDate getDataDeMatricula() {
		return dataDeMatricula;
	}

	public void setDataDeMatricula(LocalDate dataDeMatricula) {
		this.dataDeMatricula = dataDeMatricula;
	}

	public LocalDate getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(LocalDate dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public StatusDaMatricula getStatusDaMatricula() {
		return statusDaMatricula;
	}

	public void setStatusDaMatricula(StatusDaMatricula statusDaMatricula) {
		this.statusDaMatricula = statusDaMatricula;
	}

	/*public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}*/
}