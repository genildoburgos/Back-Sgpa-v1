package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.UnidadeRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.UnidadeResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Unidade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/unidade")
public class UnidadeController {

    @Autowired
    private Facade facade;

    @GetMapping
    public List<UnidadeResponse> listarUnidades() {
        return facade.listarUnidades()
                .stream()
                .map(UnidadeResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadeResponse criarUnidade(@RequestBody UnidadeRequest novaUnidade) {
        return new UnidadeResponse(facade.criarUnidade(novaUnidade.toUnidade()));
    }

    @GetMapping("buscar/{id}")
    public UnidadeResponse buscarUnidade(@PathVariable Long id) {
        return new UnidadeResponse(facade.buscarUnidade(id));
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUnidade(@PathVariable Long id) {
        facade.deletarUnidade(id);
    }

    @PutMapping("atualizar/{id}")
    public UnidadeResponse atualizarUnidade(@RequestBody UnidadeRequest unidadeAtualizada, @PathVariable Long id) {
        return new UnidadeResponse(facade.atualizarUnidade(unidadeAtualizada.toUnidade(), id));
    }

    @GetMapping("buscar/{nome}")
    public List<UnidadeResponse> buscarUnidadesPorNome(@PathVariable String nome) {
        return facade.buscarUnidadesPorNome(nome)
                .stream()
                .map(UnidadeResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("buscar/{cnpj}")
    public UnidadeResponse buscarUnidadePorCnpj(@PathVariable String cnpj) {
        return new UnidadeResponse(facade.buscarUnidadePorCnpj(cnpj));
    }
}
