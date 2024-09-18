package br.edu.ufape.poo.sgpa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import jakarta.persistence.*;

@Entity
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne
	private Instrutor instrutor;
	
	@OneToMany(mappedBy = "turma")
	private List<Matricula> matriculas;
	
	@Enumerated(EnumType.STRING)
	private Modalidade modalidade;
	
	@ManyToOne
	private Sala sala;
	
	@OneToOne
	private Vaga vaga;
	
	public Turma() {
		this.matriculas = new ArrayList<>();
	}
	
	public Turma(Instrutor instrutor, Sala sala, Vaga vagas, Modalidade modalidade) {
		this.instrutor = instrutor;
		this.modalidade = modalidade;
		this.sala = sala;
		this.vaga = vagas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getInstrutor(), getMatriculas(), getModalidade(), getSala(), getVaga());
	}

	@Override
	public String toString() {
		return "Turma{" +
				"id=" + id +
				", instrutor=" + instrutor +
				", matriculas=" + matriculas +
				", modalidade=" + modalidade +
				", sala=" + sala +
				", vagas=" + vaga +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return id == other.id && 
				modalidade == other.modalidade && Objects.equals(sala, other.sala) && Objects.equals(vaga, other.vaga)
				&& Objects.equals(instrutor, other.instrutor);
	}
	
	public long getId() {
		return id;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vagas) {
		this.vaga = vagas;
	}
}
