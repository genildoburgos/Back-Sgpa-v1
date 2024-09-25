package br.edu.ufape.poo.sgpa.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.sgpa.controller.dto.request.MatriculaRequest;
import br.edu.ufape.poo.sgpa.controller.dto.request.MembroRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.MatriculaResponse;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/matricula")
public class MatriculaController {

	@Autowired
	private Facade facade;

	@PostMapping
	public MatriculaResponse criarMatricula(@RequestBody MatriculaRequest matricula) throws MembroNaoExisteException, TurmaNaoExisteException {
		return new MatriculaResponse(facade.criarMatricula(matricula.toMatricula()));
	}

	@GetMapping
	public List<MatriculaResponse> listarMatriculas() {
		return facade.listarMatriculas().stream().map(MatriculaResponse::new).collect(Collectors.toList());
	}

	@GetMapping("id/{id}")
	public MatriculaResponse buscarMatriculaPorId(@PathVariable Long id) {
		return new MatriculaResponse(facade.buscarMatriculaPorId(id));
	}

	@DeleteMapping("/{id}")
	public void deletarMatricula(@PathVariable Long id) {
		facade.deletarMatricula(id);
	}

	@PutMapping("/{id}")
	public MatriculaResponse atualizarMatricula(@RequestBody MatriculaRequest matriculaAtualizada,
			@PathVariable Long id) {
		return new MatriculaResponse(facade.atualizarMatricula(matriculaAtualizada.toMatricula(), id));
	}

	@GetMapping("membro")
	public List<MatriculaResponse> buscarMatriculasPorMembro(@RequestBody MembroRequest membroRequest) {

		Membro membro = membroRequest.toMembro();

		return facade.buscarMatriculasPorMembro(membro).stream().map(MatriculaResponse::new)
				.collect(Collectors.toList());
	}

	@GetMapping("dataexpiracao/{dataexpiracao}")
	public List<Matricula> buscarMatriculaPorDataExpiracao(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataExpiracao) {
		return facade.buscarMatriculaPorDataExpiracao(dataExpiracao);
	}

	@GetMapping("datadematricula/{datadematricula}")
	public List<Matricula> buscarMatriculaPorDataDeMatricula(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataMatricula) {
		return facade.buscarMatriculaPorDataDeMatricula(dataMatricula);
	}

	@GetMapping("status/{status}")
	public List<Matricula> buscarMatriculaPorStatus(@PathVariable StatusDaMatricula status) {
		return facade.buscarMatriculaPorStatus(status);
	}

	@PutMapping("ativar/{id}")
	public void ativarMatricula(@PathVariable Long id) {
		facade.ativarMatricula(facade.buscarMatriculaPorId(id));
	}

	@PutMapping("suspender/{id}")
	public void suspenderMatricula(@PathVariable Long id) {
		facade.suspenderMatricula(facade.buscarMatriculaPorId(id));
	}

	@GetMapping("expirada/{id}")
	public boolean matriculaEstaExpirada(@PathVariable Long id) {
		return facade.matriculaEstaExpirada(facade.buscarMatriculaPorId(id));
	}
}
