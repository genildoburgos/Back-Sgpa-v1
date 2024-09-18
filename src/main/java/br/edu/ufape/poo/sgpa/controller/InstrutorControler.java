package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.InstrutorRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.InstrutorResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/instrutor")

public class InstrutorControler {
    @Autowired
    private Facade facade;


    @GetMapping
    public List <InstrutorResponse> listarInstrutores(){
        return facade.listarInstrutores()
                .stream()
                .map(InstrutorResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstrutorResponse criarInstrutor(@RequestBody InstrutorRequest novoObj){
        return new InstrutorResponse(facade.criarInstrutor(novoObj.toInstrutor()));
    }

    @GetMapping("buscar/{id}")
    public InstrutorResponse buscarPorId(@PathVariable Long id) {
        return new InstrutorResponse(facade.buscarInstrutor(id));
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInstrutor(@PathVariable Long id){
        facade.deletarInstrutor(id);
    }

    @PutMapping("atualizar/{id}")
    public InstrutorResponse atualizarInstrutor(@RequestBody InstrutorRequest instrutorAtualizado, @PathVariable Long id){
        return new InstrutorResponse(facade.atualizarInstrutor(instrutorAtualizado.toInstrutor(), id));
    }

    // além do CRUD

    @GetMapping("cpf/{cpf}")
    public InstrutorResponse buscarPorCpf(@PathVariable String cpf) {
        return new InstrutorResponse(facade.buscarInstrutorPorCpf(cpf));
    }

    @GetMapping("nome/{nome}")
    public List <InstrutorResponse> buscarPorNome(@PathVariable String nome) {
        return facade.buscarInstrutorPorNome(nome)
                .stream()
                .map(InstrutorResponse::new)
                .collect(Collectors.toList());
    }






}
