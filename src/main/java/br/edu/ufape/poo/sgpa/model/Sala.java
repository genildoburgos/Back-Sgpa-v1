package br.edu.ufape.poo.sgpa.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sala implements ISala {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private String bloco;

	private String numero;

	private int capacidade;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<SlotHorario> slotsHorario;
	
	public Sala() {
	}
	
	public Sala(String bloco, String numero, int capacidade, List<SlotHorario> slotHorarios) {
		this.bloco = bloco;
		this.numero = numero;
		this.capacidade = capacidade;
		this.slotsHorario = slotHorarios;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", bloco=" + bloco + ", numero=" + numero + ", capacidade=" + capacidade
				+ ", slotsHorario=" + slotsHorario + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(bloco, other.bloco) && capacidade == other.capacidade && id == other.id
				&& Objects.equals(numero, other.numero) && Objects.equals(slotsHorario, other.slotsHorario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloco, capacidade, id, numero, slotsHorario);
	}
	 
	public long getId() {
		return id;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<SlotHorario> getSlotsHorario() {
        return slotsHorario;
    }

    public void setSlotsHorario(List<SlotHorario> slotsHorario) {
        this.slotsHorario = slotsHorario;
    }
	
	@Override
	public void reservarSala(SlotHorario slotHorario) {
		this.slotsHorario.add(slotHorario);
	}
}
