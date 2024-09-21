package br.edu.ufape.poo.sgpa.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ufape.poo.sgpa.controller.dto.response.SalaResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Sala;
import br.edu.ufape.poo.sgpa.exception.SalaNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.SalaExisteException;

@RestController
@RequestMapping("api/v1/sala")
public class SalaController {

    @Autowired
    private Facade facade;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sala criarSala(@RequestBody Sala novaSala) throws CampoObrigatorioNuloException, SalaExisteException{
        return facade.criarSala(novaSala);
        
    }

     @GetMapping("/id/{id}")
     public Optional<Sala> buscarSalaPorId(@PathVariable Long id) throws SalaNaoExisteException {
        return facade.buscarSalaPorId(id);
    }
       

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarSalaPorId(@PathVariable Long id) throws SalaNaoExisteException {
        facade.deletarSalaPorId(id);
    }

    @DeleteMapping("deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarSala(@PathVariable Sala entity) throws SalaNaoExisteException {
        facade.deletarSala(entity);
    }


    
    @GetMapping("buscar/bloco/{bloco}/numero/{numero}")
    public SalaResponse buscarSalaPorBlocoENumero(@PathVariable String bloco, @PathVariable String numero) {
        return facade.buscarSalaPorBlocoENumero(bloco, numero)
                .map(SalaResponse::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
    }


    @GetMapping("/bloco/{bloco}")
    List<Sala> findByBloco(String bloco){
        return facade.findByBloco(bloco);
    }

}
