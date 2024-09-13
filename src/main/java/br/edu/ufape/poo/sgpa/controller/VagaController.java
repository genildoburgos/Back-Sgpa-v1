package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.VagaRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.VagaResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Vaga;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/vaga")
public class VagaController {

    @Autowired
    private Facade facade;

    @GetMapping
    public List<VagaResponse> listarVagas() {
        return facade.listarVagas()
                .stream()
                .map(VagaResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VagaResponse criarVaga(@RequestBody VagaRequest novoObj){
        return new VagaResponse(facade.criarVaga(novoObj.toVaga()));
    }

    @GetMapping("buscar/{id}")
    public VagaResponse buscarPorId(@PathVariable Long id) {
        return new VagaResponse(facade.buscarVagaPorId(id));
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarVaga(@PathVariable Long id){
        facade.deletarVaga(id);
    }

    @PutMapping("atualizar/{id}")
    public VagaResponse atualizarVaga(@RequestBody VagaRequest vagaAtualizada, @PathVariable Long id){
        return new VagaResponse(facade.atualizarVaga(vagaAtualizada.toVaga(), id));
    }
}
