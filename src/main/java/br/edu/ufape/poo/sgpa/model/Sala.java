package br.edu.ufape.poo.sgpa.model;

public class Sala {
	private String bloco;
	private String numero;
	private int capacidade;
	// Falta classe slotHorario
	
	public Sala(String bloco, String numero, int capacidade) {
		this.bloco = bloco;
		this.numero = numero;
		this.capacidade = capacidade;
		// Falta classe slotHorario
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
		// Falta classe SlotHorario
	}
}
