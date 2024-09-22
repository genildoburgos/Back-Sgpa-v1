package br.edu.ufape.poo.sgpa.service;

import java.util.List;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.TurmaComMembrosException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

public interface ITurmaService {

	Turma atualizarTurma(Turma turmaAtualizada, Long id) throws TurmaNaoExisteException, CampoObrigatorioNuloException;
	Turma buscarTurmaPorId(Long id) throws TurmaNaoExisteException;
	List<Turma> buscarTurmasPorModalidade(Modalidade modalidade);
	List<Turma> buscarTurmasPorInstrutor(Instrutor instrutor);
	List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Instrutor instrutor);
	Turma cadastrarTurma(Turma entity) throws CampoObrigatorioNuloException;
	void deletarTurma(Long id) throws TurmaNaoExisteException, TurmaComMembrosException;
	List<Turma> listarTurmas();
	boolean verificarExistenciaTurmaId(Long id);
	
}
