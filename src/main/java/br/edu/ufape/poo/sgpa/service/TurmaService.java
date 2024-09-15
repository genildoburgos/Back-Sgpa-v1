package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import br.edu.ufape.poo.sgpa.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TurmaService implements ITurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Override
	public Turma atualizarTurma(Turma turmaAtualizada, Long id) {
        Turma turmaExistente = repository.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Turma não existe")
        );

        turmaExistente.setInstrutor(turmaAtualizada.getInstrutor());
        turmaExistente.setModalidade(turmaAtualizada.getModalidade());
        turmaExistente.setSala(turmaAtualizada.getSala());
        turmaExistente.setVaga(turmaAtualizada.getVaga());

        return repository.save(turmaExistente);
    }
	
	@Override
	public Turma buscarTurmaPorId(Long id) {
		return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Turma não encontrada"));
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
	public Turma cadastrarTurma(Turma entity) {
        Turma turma = new Turma();
        
        turma.setInstrutor(entity.getInstrutor());
        turma.setModalidade(entity.getModalidade());
        turma.setSala(entity.getSala());
        turma.setVaga(entity.getVaga());
        
        return repository.save(turma);
    }

	@Override
	public void deletarTurma(Long id) throws TurmaNaoExisteException {
		if (!repository.existsById(id)) {
            throw new TurmaNaoExisteException();
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
