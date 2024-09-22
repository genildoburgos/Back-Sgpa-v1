package br.edu.ufape.poo.sgpa.service;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.CpfInvalidoException;
import br.edu.ufape.poo.sgpa.exception.DataForaDaFaixaException;
import br.edu.ufape.poo.sgpa.exception.MembroDuplicadoException;
import br.edu.ufape.poo.sgpa.exception.MembroMenorDeIdadeException;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;
import br.edu.ufape.poo.sgpa.model.Membro;

public interface IMembroService {
	
	public Optional<Membro> buscarMembroPorCpf(String cpf) throws MembroNaoExisteException;
	public Optional<Membro> buscarMembroPorId(Long id) throws MembroNaoExisteException;
	public Optional<Membro> buscarMembroPorNumeroDeMatricula(String numeroDeMatricula) throws MembroNaoExisteException;
	public List<Membro> buscarMembroPorNome(String nome);
	public List<Membro> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(String cpf, String numeroDeMatricula, String nome);
	public Membro cadastrarMembro(Membro novoMembro) throws CampoObrigatorioNuloException, CpfInvalidoException, MembroDuplicadoException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException;
	public void deletarMembroPorCpf(String cpf) throws MembroNaoExisteException;
	public String gerarMatricula();
	public List<Membro> listarMembros();
	public Membro atualizarMembro(Membro membroAtualizado, Long id)
			throws MembroNaoExisteException, CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException;
	
}
