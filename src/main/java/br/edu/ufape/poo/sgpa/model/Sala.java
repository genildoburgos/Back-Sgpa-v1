package br.edu.ufape.poo.sgpa.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "sala", schema = "academia")
public class Sala {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name="bloco")
	private String bloco;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="capacidade")
	private int capacidade;
	
	//@OneToMany(mappedBy = "sala")
	//private List<SlotHorario> slotsHorario;
	
	public Sala() {
	}
	
	public Sala(String bloco, String numero, int capacidade) {
		this.bloco = bloco;
		this.numero = numero;
		this.capacidade = capacidade;
		//this.slotsHorario = new ArrayList<>();
	}
	
	@Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", bloco='" + bloco + '\'' +
                ", numero='" + numero + '\'' +
                ", capacidade=" + capacidade +
                //", slotsHorario=" + slotsHorario.toString()
                '}';
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Sala sala)) return false;
			return getId() == sala.getId() &&
	               getCapacidade() == sala.getCapacidade() &&
	               Objects.equals(getBloco(), sala.getBloco()) &&
	               Objects.equals(getNumero(), sala.getNumero());
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(getId(), getBloco(), getNumero(), getCapacidade());
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
	
	public void reservarSala() {
		//this.slotsHorario.add(slotHorario);
	}
}
