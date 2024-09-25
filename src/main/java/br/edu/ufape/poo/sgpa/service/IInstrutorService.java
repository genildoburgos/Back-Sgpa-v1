package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.exception.InstrutorNaoEncontradoException;
import br.edu.ufape.poo.sgpa.model.Instrutor;

import java.util.List;

public interface IInstrutorService {
    Instrutor criarInstrutor(Instrutor obj);

    List<Instrutor> listarInstrutores();

    Instrutor buscarInstrutor(Long id);

    void deletarIntrutor(Long id);

    Instrutor atualizarInstrutor(Instrutor instrutor, Long id) throws InstrutorNaoEncontradoException;

    Instrutor buscarInstrutorPorCpf(String cpf);

    List<Instrutor> buscarInstrutoresPorNome(String nome);

    default void validaInstrutor(Instrutor instrutor) {
        if (instrutor.getNome() == null || instrutor.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do instrutor não pode ser vazio.");
        }
        if (instrutor.getCpf() == null || instrutor.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF do instrutor não pode ser vazio.");
        }
        if (instrutor.getEmail() == null || instrutor.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do instrutor não pode ser vazio.");
        }
        // Adicione outras validações necessárias
    }
}
