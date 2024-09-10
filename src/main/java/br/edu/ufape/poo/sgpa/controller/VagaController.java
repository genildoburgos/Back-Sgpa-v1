package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.VagaRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.VagaResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
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
        try{
            return new VagaResponse(facade.criarVaga(novoObj));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para criar uma vaga", e);
        }
    }

    @GetMapping("buscar/{id}")
    public VagaResponse buscarPorId(@PathVariable Long id) {
        try{
            return new VagaResponse(facade.buscarVagaPorId(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada com o id " + id, e);
        }
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarVaga(@PathVariable Long id){
        try{
            facade.deletarVaga(id);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada com o id " + id, e);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar a vaga", e);
        }
    }

    @PutMapping("atualizar/{id}")
    public VagaResponse atualizarVaga(@PathVariable Long id, @RequestBody VagaRequest vagaAtualizada){
        try{
            return new VagaResponse(facade.atualizarVaga(id, vagaAtualizada));
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vaga não encotrada com o id "+ id, e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para atualizar a vaga", e);
        }
    }
}
