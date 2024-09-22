package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.SalaDuplicadaException;
import br.edu.ufape.poo.sgpa.exception.SalaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Sala;

public interface ISalaService {

	Optional<Sala> buscarSalaPorId(Long id) throws SalaNaoExisteException;

	void deletarSalaPorId(Long id) throws SalaNaoExisteException;

	void deletarSala(Sala entity) throws SalaNaoExisteException;

	Sala criarSala(Sala sala) throws CampoObrigatorioNuloException, SalaDuplicadaException;

	List<Sala> findByBloco(String bloco);

	Optional<Sala> buscarSalaPorBlocoENumero(String bloco, String numero);

}
