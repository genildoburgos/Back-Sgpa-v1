package br.edu.ufape.poo.sgpa.model;

import java.time.LocalDate;
import java.util.Objects;

import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Matricula
		//implements IMatricula
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private LocalDate dataDeMatricula;
	private LocalDate dataDeExpiracao;
	
	@Enumerated(EnumType.STRING)
	private StatusDaMatricula statusDaMatricula;
	
	@ManyToOne
    private Membro membro;
	
	@ManyToOne
	private Turma turma; 
	
	public Matricula() {	
	}
	
	public Matricula(LocalDate dataDeMatricula, LocalDate dataDeExpiracao, Membro membro, Turma turma) {
		this.dataDeMatricula = dataDeMatricula;
		this.dataDeExpiracao = dataDeExpiracao;
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
		this.membro = membro;
		this.turma = turma;
	}
	/*
	@Override
	public void ativarMatricula() {
		this.statusDaMatricula = StatusDaMatricula.ATIVA;
	}
	
	@Override
	public void suspenderMatricula() {
		this.statusDaMatricula = StatusDaMatricula.SUSPENSA;
	}
	
	@Override
	public boolean estaExpirada() {
        return LocalDate.now().isAfter(this.dataDeExpiracao);
    }

	 */

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", dataDeMatricula=" + dataDeMatricula + ", dataDeExpiracao=" + dataDeExpiracao
				+ ", statusDaMatricula=" + statusDaMatricula + ", membro=" + membro + ", turma=" + turma + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeExpiracao, dataDeMatricula, id, membro, statusDaMatricula, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(dataDeExpiracao, other.dataDeExpiracao)
				&& Objects.equals(dataDeMatricula, other.dataDeMatricula) && id == other.id
				&& Objects.equals(membro, other.membro) && statusDaMatricula == other.statusDaMatricula
				&& Objects.equals(turma, other.turma);
	}

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

	public Membro getMembro() {
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
	}
}
