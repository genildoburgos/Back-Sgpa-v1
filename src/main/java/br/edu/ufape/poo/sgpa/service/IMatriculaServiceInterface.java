package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;

import java.time.LocalDate;
import java.util.List;

public interface IMatriculaServiceInterface {
    Matricula criarMatricula(Matricula matricula);

    List <Matricula> listarMatriculas();
    Matricula buscarMatricula(Long id);
    void deletarMatricula(Long id);
    Matricula atualizarMatricula(Matricula matricula, Long id);

    List<Matricula> buscarMatriculasPorMembro(Membro membro);
    List<Matricula> buscarPorDataExpiracao(LocalDate dataExpiracao);
    List<Matricula> buscarPorDataDeMatricula(LocalDate dataExpiracao);
    List<Matricula> buscarPorStatus(StatusDaMatricula status);

    void ativarMatricula(Matricula matricula);

    void suspenderMatricula(Matricula matricula);

    boolean estaExpirada(Matricula matricula);

    default void validarMatricula(Matricula matricula) {
        if (matricula.getDataDeMatricula() == null) {
            throw new IllegalArgumentException("A data da matricula não pode ser vazia.");
        }
        if (matricula.getTurma() == null) {
            throw new IllegalArgumentException("A turma que o membro se matriculou não pode ser vazia.");
        }
        if (matricula.getDataDeExpiracao().isBefore(matricula.getDataDeMatricula())) {
            throw new IllegalArgumentException("A data de expiração não pode ser anterior a data de matricula.");
        }
        if(matricula.getMembro() == null){
            throw new IllegalArgumentException("O membro que se matriculou não pode ser vazio.");
        }
        // Adicione outras validações necessárias
    }
    
}
