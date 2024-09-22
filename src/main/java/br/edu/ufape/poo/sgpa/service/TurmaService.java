package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.TurmaComMembrosException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import br.edu.ufape.poo.sgpa.repository.TurmaRepository;

@Service
public class TurmaService implements ITurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Override
	public Turma atualizarTurma(Turma turmaAtualizada, Long id) throws TurmaNaoExisteException, CampoObrigatorioNuloException {
        Turma turmaExistente = repository.findById(id).orElseThrow(() -> 
             new TurmaNaoExisteException());
        if (turmaAtualizada.getInstrutor() == null || turmaAtualizada.getModalidade() == null || turmaAtualizada.getSala() == null
				|| turmaAtualizada.getVaga() == null) {
			throw new CampoObrigatorioNuloException();
		}

        turmaExistente.setInstrutor(turmaAtualizada.getInstrutor());
        turmaExistente.setModalidade(turmaAtualizada.getModalidade());
        turmaExistente.setSala(turmaAtualizada.getSala());
        turmaExistente.setVaga(turmaAtualizada.getVaga());

        return repository.save(turmaExistente);
    }
	
	@Override
	public Turma buscarTurmaPorId(Long id) throws TurmaNaoExisteException {
		return repository.findById(id).orElseThrow(()-> new TurmaNaoExisteException());
	}
	
	@Override
	public List<Turma> buscarTurmasPorModalidade(Modalidade modalidade) {
		return repository.findByModalidade(modalidade);
	}

	@Override
	public List<Turma> buscarTurmasPorInstrutor(Instrutor instrutor) {
		return repository.findByInstrutor(instrutor);
	}

	@Override
	public List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Instrutor instrutor) {
		return repository.findByModalidadeOrInstrutor(modalidade, instrutor);
	}
	
	@Override
	public Turma cadastrarTurma(Turma entity) throws CampoObrigatorioNuloException {
		if (entity.getInstrutor() == null || entity.getModalidade() == null || entity.getSala() == null
				|| entity.getVaga() == null) {
			throw new CampoObrigatorioNuloException();
		}

		return repository.save(entity);
	}

	@Override
	public void deletarTurma(Long id) throws TurmaNaoExisteException, TurmaComMembrosException {
		Turma turma = repository.findById(id).orElseThrow(() -> new TurmaNaoExisteException());
		
		if (turma.getMatriculas() != null && !turma.getMatriculas().isEmpty()) {
	        throw new TurmaComMembrosException();
	    }
		
		repository.deleteById(id);
	}

	@Override
	public List<Turma> listarTurmas() {
		return repository.findAll();
	}
	
	@Override
	public boolean verificarExistenciaTurmaId(Long id) {
		return repository.existsById(id);
	}
	
}
