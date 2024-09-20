package br.edu.ufape.poo.sgpa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import br.edu.ufape.poo.sgpa.controller.dto.request.MembroRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.MembroResponse;
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
	public MembroResponse atualizarMembro(@RequestBody MembroRequest m, @PathVariable Long id) throws MembroNaoExisteException,
			CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException {
		return new MembroResponse(facade.atualizarMembro(m.toMembro(), id));
	}

	@GetMapping("/cpf/{cpf}")
	public Optional<MembroResponse> buscarMembroPorCpf(@PathVariable String cpf) throws MembroNaoExisteException {
		return facade.buscarMembroPorCpf(cpf).map(MembroResponse::new);
	}
	
	@GetMapping("id/{id}")
	public Optional<MembroResponse> buscarMembroPorId(@PathVariable Long id) throws MembroNaoExisteException {
		return facade.buscarMembroPorId(id)
                .map(MembroResponse::new);
	}

	@GetMapping("/matricula/{numeroDeMatricula}")
	public Optional<MembroResponse> buscarMembroPorNumeroDeMatricula(@PathVariable String numeroDeMatricula)
	        throws MembroNaoExisteException {
	    
	    return facade.buscarMembroPorNumeroDeMatricula(numeroDeMatricula)
	                 .map(MembroResponse::new);
	}


	@GetMapping("/nome")
	public List<MembroResponse> buscarMembroPorNome(@RequestParam String nome) {
		return facade.buscarMembroPorNome(nome)
                .stream()
                .map(MembroResponse::new)
                .collect(Collectors.toList());
	}

	@GetMapping("/pesquisa")
	public List<MembroResponse> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(
	        @RequestParam(required = false) String cpf,
	        @RequestParam(required = false) String numeroDeMatricula,
	        @RequestParam(required = false) String nome) {
	    
	    return facade.buscarMembroPorCpfOuNumeroDeMatriculaOuNome(cpf, numeroDeMatricula, nome)
	                 .stream()
	                 .map(MembroResponse::new)
	                 .collect(Collectors.toList());
	}


	@PostMapping
	public MembroResponse cadastrarMembro(@RequestBody MembroRequest m) throws CampoObrigatorioNuloException, CpfInvalidoException,
			MembroExisteException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException {
		return new MembroResponse(facade.cadastrarMembro(m.toMembro()));
	}

	@DeleteMapping("/cpf/{cpf}")
	public void deletarMembroPorCpf(@PathVariable String cpf) throws MembroNaoExisteException {
		facade.deletarMembroPorCpf(cpf);
	}

	@GetMapping
	public List<MembroResponse> listarMembros() {
		return facade.listarMembros()
                .stream()
                .map(MembroResponse::new)
                .collect(Collectors.toList());
	}
	
}
