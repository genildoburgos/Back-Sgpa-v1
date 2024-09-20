package br.edu.ufape.poo.sgpa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.CpfInvalidoException;
import br.edu.ufape.poo.sgpa.exception.DataForaDaFaixaException;
import br.edu.ufape.poo.sgpa.exception.MembroExisteException;
import br.edu.ufape.poo.sgpa.exception.MembroMenorDeIdadeException;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;
import br.edu.ufape.poo.sgpa.model.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.sgpa.repository.MembroRepository;
import jakarta.transaction.Transactional;

@Service
public class MembroService implements IMembroService {

	@Autowired
	private MembroRepository repository;

	@Override
	public Membro atualizarMembro(Membro membroAtualizado, Long id) throws MembroNaoExisteException,
			CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException {

		Optional<Membro> membroOpt = repository.findById(id);
		if (!membroOpt.isPresent()) {
			throw new MembroNaoExisteException();
		}

		Membro membroExistente = membroOpt.get();

		if (membroAtualizado.getNome() == null || membroAtualizado.getNome().isEmpty()
				|| membroAtualizado.getDataDeNascimento() == null || membroAtualizado.getTelefone() == null
				|| membroAtualizado.getTelefone().isEmpty() || membroAtualizado.getContatoDeEmergencia() == null
				|| membroAtualizado.getContatoDeEmergencia().isEmpty()) {
			throw new CampoObrigatorioNuloException();
		}

		if (!(membroAtualizado.checarTelefone(membroAtualizado.getTelefone()))) {
			throw new TelefoneInvalidoException();
		}

		if (membroAtualizado.getDataDeNascimento().isAfter(LocalDate.now())) {
			throw new DataForaDaFaixaException();
		}

		membroExistente.setNome(membroAtualizado.getNome());
		membroExistente.setDataDeNascimento(membroAtualizado.getDataDeNascimento());
		membroExistente.setTelefone(membroAtualizado.getTelefone());
		membroExistente.setContatoDeEmergencia(membroAtualizado.getContatoDeEmergencia());
		membroExistente.setStatusDePagamento(membroAtualizado.getStatusDePagamento());

		membroExistente.setMatriculas(membroAtualizado.getMatriculas());
		membroExistente.setResponsavel(membroAtualizado.getResponsavel());
		membroExistente.setTurmas(membroAtualizado.getTurmas());

		return repository.save(membroExistente);
	}

	@Override
	public Optional<Membro> buscarMembroPorCpf(String cpf) throws MembroNaoExisteException {
		Optional<Membro> membroOpt = repository.findByCpfOrderByNome(cpf);
		if (!membroOpt.isPresent()) {
			throw new MembroNaoExisteException();
		}
		return membroOpt;
	}
	
	@Override
	public Optional<Membro> buscarMembroPorId(Long id) throws MembroNaoExisteException {
		Optional<Membro> membroOpt = repository.findById(id);
		if (!membroOpt.isPresent()) {
			throw new MembroNaoExisteException();
		}
		return membroOpt;
	}

	@Override
	public Optional<Membro> buscarMembroPorNumeroDeMatricula(String numeroDeMatricula) throws MembroNaoExisteException {
		Optional<Membro> membroOpt = repository.findByNumeroDeMatriculaOrderByNome(numeroDeMatricula);
		if (!membroOpt.isPresent()) {
			throw new MembroNaoExisteException();
		}
		return membroOpt;
	}

	@Override
	public List<Membro> buscarMembroPorNome(String nome) {
		return repository.findByNomeContainingIgnoreCaseOrderByNome(nome);
	}

	@Override
	public List<Membro> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(String cpf, String numeroDeMatricula, String nome) {
		return repository.findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNome(cpf, numeroDeMatricula,
				nome);
	}

	@Override
	public Membro cadastrarMembro(Membro entity) throws CampoObrigatorioNuloException, CpfInvalidoException,
			MembroExisteException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException {

		if (entity.getCpf() == null || entity.getCpf().isEmpty() || entity.getNome() == null
				|| entity.getNome().isEmpty() || entity.getDataDeNascimento() == null || entity.getTelefone() == null
				|| entity.getTelefone().isEmpty() || entity.getContatoDeEmergencia() == null
				|| entity.getContatoDeEmergencia().isEmpty()) {
			throw new CampoObrigatorioNuloException();
		}

		if (entity.getDataDeNascimento().isAfter(LocalDate.now())) {
			throw new DataForaDaFaixaException();
		}

		if (!(entity.checarTelefone(entity.getTelefone()))) {
			throw new TelefoneInvalidoException();
		}

		if (!(entity.validarCPF(entity.getCpf()))) {
			throw new CpfInvalidoException();
		}

		if (entity.getIdade() < 18 && entity.getResponsavel() == null) {
			throw new MembroMenorDeIdadeException();
		}

		if (repository.findByCpfOrderByNome(entity.getCpf()).isPresent()) {
			throw new MembroExisteException();
		}

		return repository.save(entity);
	}

	@Transactional
	@Override
	public void deletarMembroPorCpf(String cpf) throws MembroNaoExisteException {
		Optional<Membro> membroOpt = repository.findByCpfOrderByNome(cpf);
		if (!membroOpt.isPresent()) {
			throw new MembroNaoExisteException();
		}
		repository.deleteByCpf(cpf);
	}

	@Override
	public List<Membro> listarMembros() {
		return repository.findAll();
	}

}
