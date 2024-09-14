package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Unidade;

import java.util.List;

public interface UnidadeServiceInterface {
    Unidade criarUnidade(Unidade obj);

    List<Unidade> listarUnidades();

    Unidade buscarUnidade(Long id);

    void deletarUnidade(Long id);

    void atualizarUnidade(Unidade obj, Long id);

    default void validarUnidade(Unidade unidade) {
        if (unidade.getEndereco().getCidade() == null || unidade.getEndereco().getCidade().isEmpty()
                || unidade.getEndereco().getRua() == null || unidade.getEndereco().getRua().isEmpty()
                || unidade.getEndereco().getEstado() == null || unidade.getEndereco().getEstado().isEmpty()) {
            throw new IllegalArgumentException("Endereço da unidade não pode ser nulo.");
        }
        if (unidade.getNome() == null || unidade.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da unidade não pode ser nulo.");
        }
        if (unidade.getSalas() == null || unidade.getSalas().isEmpty()) {
            throw new IllegalArgumentException("As salas da unidade não podem ser nulas.");
        }
        if (unidade.getAdministrador() == null || unidade.getAdministrador().getNome().isEmpty()) {
            throw new IllegalArgumentException("O administrador da unidade não pode ser nulo.");
        }
    }
}
