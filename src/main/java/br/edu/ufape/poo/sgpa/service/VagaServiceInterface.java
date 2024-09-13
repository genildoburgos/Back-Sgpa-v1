package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Vaga;

import java.util.List;

public interface VagaServiceInterface {
    List<Vaga> listarVagas();

    Vaga criarVaga(Vaga novaInstancia);

    void deletarVaga(Long id);

    Vaga atualizarVaga(Long id, Vaga vaga);

    Vaga buscarVagaPorId(Long id);
}
