package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.controller.dto.request.TurmaRequest;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

import java.util.List;

public interface TurmaServiceInterface {
    Turma buscarTurmaPorId(Long id);

    List<Turma> buscarTurmasPorModalidade(Modalidade modalidade);

    List<Turma> buscarTurmasPorInstrutor(Instrutor instrutor);

    List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Instrutor instrutor);

    boolean verificarExistenciaTurmaId(Long id);

    void deletarTurma(Long id);

    List<Turma> listarTurmas();

    Turma atualizarTurma(Long id, TurmaRequest turmaRequest);

    Turma cadastrarTurma(TurmaRequest turmaRequest);
}
