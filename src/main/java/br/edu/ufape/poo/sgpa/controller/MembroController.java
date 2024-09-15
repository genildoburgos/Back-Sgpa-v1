package br.edu.ufape.poo.sgpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.CpfInvalidoException;
import br.edu.ufape.poo.sgpa.exception.DataForaDaFaixaException;
import br.edu.ufape.poo.sgpa.exception.MembroExisteException;
import br.edu.ufape.poo.sgpa.exception.MembroMenorDeIdadeException;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;
import br.edu.ufape.poo.sgpa.facade.Facade;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/membro")
public class MembroController {

	@Autowired
	private Facade facade;

	@PatchMapping("/{id}")
	public void atualizarMembro(@RequestBody Membro m, @PathVariable Long id) throws MembroNaoExisteException,
			CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException {
		facade.atualizarMembro(m, id);
	}

	@GetMapping("/cpf/{cpf}")
	public Optional<Membro> buscarMembroPorCpf(@PathVariable String cpf) throws MembroNaoExisteException {
		return facade.buscarMembroPorCpf(cpf);
	}

	@GetMapping("/matricula/{numeroDeMatricula}")
	public Optional<Membro> buscarMembroPorNumeroDeMatricula(@PathVariable String numeroDeMatricula)
			throws MembroNaoExisteException {
		return facade.buscarMembroPorNumeroDeMatricula(numeroDeMatricula);
	}

	@GetMapping("/nome")
	public List<Membro> buscarMembroPorNome(@RequestParam String nome) {
		return facade.buscarMembroPorNome(nome);
	}

	@GetMapping("/pesquisa")
	public List<Membro> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(@RequestParam(required = false) String cpf,
			@RequestParam(required = false) String numeroDeMatricula, @RequestParam(required = false) String nome) {
		return facade.buscarMembroPorCpfOuNumeroDeMatriculaOuNome(cpf, numeroDeMatricula, nome);
	}

	@PostMapping
	public void cadastrarMembro(@RequestBody Membro m) throws CampoObrigatorioNuloException, CpfInvalidoException,
			MembroExisteException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException {
		facade.cadastrarMembro(m);
	}

	@DeleteMapping("/cpf/{cpf}")
	public void deletarMembroPorCpf(@PathVariable String cpf) throws MembroNaoExisteException {
		facade.deletarMembroPorCpf(cpf);
	}

	@GetMapping
	public List<Membro> listarMembros() {
		return facade.listarMembros();
	}
}
