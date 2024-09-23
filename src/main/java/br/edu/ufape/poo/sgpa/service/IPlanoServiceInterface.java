package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Plano;

import java.util.List;

public interface PlanoServiceInterface {
    List<Plano> listarPlanos();

    Plano criarPlano(Plano novoObj);

    Plano buscarPlano(Long id);

    void deletarPlano(Long id);

    Plano atualizarPlano(Plano plano, Long id);

    default void validaPlano(Plano plano) {
        if (plano.getValor() == 0 || plano.getValor() <= 0) {
            throw new IllegalArgumentException("Valor do plano deve ser maior que zero.");
        }
        if (plano.getUnidade() == null) {
            throw new IllegalArgumentException("Unidade do plano não pode ser vazia.");
        }
    }
}
