package br.edu.ufape.poo.sgpa.service;

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

public interface IMembroService {
	
	public Optional<Membro> buscarMembroPorCpf(String cpf) throws MembroNaoExisteException;
	public Optional<Membro> buscarMembroPorNumeroDeMatricula(String numeroDeMatricula) throws MembroNaoExisteException;
	public List<Membro> buscarMembroPorNome(String nome);
	public List<Membro> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(String cpf, String numeroDeMatricula, String nome);
	public void cadastrarMembro(Membro novoMembro) throws CampoObrigatorioNuloException, CpfInvalidoException, MembroExisteException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException;
	public void deletarMembroPorCpf(String cpf) throws MembroNaoExisteException;
	public List<Membro> listarMembros();
	void atualizarMembro(Membro membroAtualizado, Long id)
			throws MembroNaoExisteException, CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException;
	
}