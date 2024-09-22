package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.SalaDuplicadaException;
import br.edu.ufape.poo.sgpa.exception.SalaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.repository.SalaRepository;

@Service
public class SalaService implements ISalaService {

	@Autowired
	private SalaRepository repository;

	@Override
	public Optional<Sala> buscarSalaPorBlocoENumero(String bloco, String numero) {
	    return repository.findByBlocoAndNumero(bloco, numero);
	}


	@Override
	public List<Sala> findByBloco(String bloco) {
		return repository.findByBloco(bloco);
	}

	@Override
	public Sala criarSala(Sala sala) throws CampoObrigatorioNuloException, SalaDuplicadaException {

		if (sala == null) {
			throw new IllegalArgumentException("A sala não pode ser nula");
		}

		if (sala.getBloco() == null || sala.getNumero() == null || sala.getCapacidade() <= 0) {
			throw new CampoObrigatorioNuloException();
		}

		Optional<Sala> salaExistente = buscarSalaPorBlocoENumero(sala.getBloco(), sala.getNumero());
        if (salaExistente.isPresent()) {
            throw new SalaDuplicadaException();
        }

		return repository.save(sala);
	}

	@Override
	public Optional<Sala> buscarSalaPorId(Long id) throws SalaNaoExisteException {
		Optional<Sala> sala = repository.findById(id);
		if (!sala.isPresent()) {
			throw new SalaNaoExisteException();
		}
		return sala;
	}

	@Override
	public void deletarSalaPorId(Long id) throws SalaNaoExisteException {
		if (!repository.existsById(id)) {
			throw new SalaNaoExisteException();
		}
		repository.deleteById(id);
	}

	@Override
	public void deletarSala(Sala entity) throws SalaNaoExisteException {
		if (!repository.existsById(entity.getId())) {
			throw new SalaNaoExisteException();
		}
		repository.delete(entity);
	}
}
