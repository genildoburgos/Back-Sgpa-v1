package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.repository.MatriculaRepository;
import br.edu.ufape.poo.sgpa.repository.MembroRepository;
import br.edu.ufape.poo.sgpa.repository.TurmaRepository;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatriculaService implements IMatriculaService{
    @Autowired
    private MatriculaRepository repository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Override
	public Matricula criarMatricula(Matricula matricula) throws MembroNaoExisteException, TurmaNaoExisteException {

		if (!validarMatricula(matricula)) {
			throw new IllegalArgumentException("Dados de matrícula inválidos");
		}

		if (!membroRepository.existsById(matricula.getMembro().getId())) {
			throw new MembroNaoExisteException();
		}

		if (!turmaRepository.existsById(matricula.getTurma().getId())) {
			throw new TurmaNaoExisteException();
		}
		return repository.save(matricula);
	}

	@Override
	public List<Matricula> listarMatriculas() {
		return repository.findAll();
	}

	@Override
	public Matricula buscarMatricula(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula com o id informado não encontrada"));
	}

	@Override
	public void deletarMatricula(Long id) {
		buscarMatricula(id);
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar Matrícula", e);
		}
	}

	@Override
	public Matricula atualizarMatricula(Matricula matricula, Long id) {
		Matricula matriculaExistente = buscarMatricula(id);
		try {
			validarMatricula(matricula);
			matriculaExistente.setDataDeMatricula(matricula.getDataDeMatricula());
			matriculaExistente.setDataDeExpiracao(matricula.getDataDeExpiracao());
			matriculaExistente.setStatusDaMatricula(matricula.getStatusDaMatricula());
			matriculaExistente.setMembro(matricula.getMembro());
			matriculaExistente.setTurma(matricula.getTurma());
			return repository.save(matriculaExistente);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar matrícula", e);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar matrícula", e);
		}
	}

	@Override
	public List<Matricula> buscarMatriculasPorMembro(Membro membro) {
		return repository.findByMembro(membro);
	}

	@Override
	public List<Matricula> buscarPorDataExpiracao(LocalDate dataExpiracao) {
		return repository.findBydataDeExpiracao(dataExpiracao);
	}

	@Override
	public List<Matricula> buscarPorDataDeMatricula(LocalDate dataMatricula) {
		return repository.findByDataDeMatricula(dataMatricula);
	}

	@Override
	public List<Matricula> buscarPorStatus(StatusDaMatricula status) {
		return repository.findByStatusDaMatricula(status);
	}

	@Override
	public void ativarMatricula(Matricula matricula) {
		matricula.setStatusDaMatricula(StatusDaMatricula.ATIVA);
		repository.save(matricula);
	}

	@Override
	public void suspenderMatricula(Matricula matricula) {
		matricula.setStatusDaMatricula(StatusDaMatricula.SUSPENSA);
		repository.save(matricula);
	}

	@Override
	public boolean estaExpirada(Matricula matricula) {
		return LocalDate.now().isAfter(matricula.getDataDeExpiracao());
	}

	@Override
	public boolean validarMatricula(Matricula matricula) {

		if (matricula.getDataDeMatricula() == null) {
			throw new IllegalArgumentException("A data da matrícula não pode ser vazia.");
		}

		if (matricula.getTurma() == null) {
			throw new IllegalArgumentException("A turma que o membro se matriculou não pode ser vazia.");
		}

		if (matricula.getDataDeExpiracao() != null
				&& matricula.getDataDeExpiracao().isBefore(matricula.getDataDeMatricula())) {
			throw new IllegalArgumentException("A data de expiração não pode ser anterior à data de matrícula.");
		}

		if (matricula.getMembro() == null) {
			throw new IllegalArgumentException("O membro que se matriculou não pode ser vazio.");
		}

		return true;
	}

}
