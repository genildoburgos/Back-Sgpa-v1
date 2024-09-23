package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Vaga;

import java.util.List;

public interface IVagaServiceInterface {
    List<Vaga> listarVagas();

    Vaga criarVaga(Vaga novaInstancia);

    void deletarVaga(Long id);

    Vaga atualizarVaga(Vaga vaga, Long id);

    Vaga buscarVagaPorId(Long id);

    default void validaVaga(Vaga novaInstancia) {
        if (novaInstancia.getCapacidade() == 0 || novaInstancia.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }
        if (novaInstancia.getQuantidade() == 0 || novaInstancia.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        if (novaInstancia.getQuantidade() > novaInstancia.getCapacidade()) {
            throw new IllegalArgumentException("Quantidade não pode ser maior que a capacidade.");
        }
    }
}
