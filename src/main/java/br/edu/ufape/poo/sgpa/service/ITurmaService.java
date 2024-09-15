package br.edu.ufape.poo.sgpa.service;

import java.util.List;

import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

public interface ITurmaService {

	Turma atualizarTurma(Turma turmaAtualizada, Long id);
	Turma buscarTurmaPorId(Long id);
	List<Turma> buscarTurmasPorModalidade(Modalidade modalidade);
	List<Turma> buscarTurmasPorInstrutor(Instrutor instrutor);
	List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Instrutor instrutor);
	Turma cadastrarTurma(Turma entity);
	void deletarTurma(Long id) throws TurmaNaoExisteException;
	List<Turma> listarTurmas();
	boolean verificarExistenciaTurmaId(Long id);
	
}
