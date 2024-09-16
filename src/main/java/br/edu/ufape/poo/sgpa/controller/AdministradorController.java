package br.edu.ufape.poo.sgpa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.poo.sgpa.controller.dto.request.AdministradorRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.AdministradorResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;


@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController {

    @Autowired
    private Facade facade;

    @GetMapping
    public List<AdministradorResponse> listarAdministradores() {
        return facade.listarAdministradores()
                .stream()
                .map(AdministradorResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdministradorResponse criarAdministrador(@RequestBody AdministradorRequest novoObj){
        return new AdministradorResponse(facade.criarAdministrador(novoObj.toAdministrador()));
    }

    
    @GetMapping("buscar/{id}")
    public AdministradorResponse buscarPorId(@PathVariable Long id) {
        return new AdministradorResponse(facade.buscarAdministradorPorId(id));
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAdministrador(@PathVariable Long id){
        facade.deletarAdministrador(id);
    }

    @PutMapping("atualizar/{id}")
    public AdministradorResponse atualizarAdministrador(@RequestBody AdministradorRequest administradorAtualizado, @PathVariable Long id){
        return new AdministradorResponse(facade.atualizarAdministrador(administradorAtualizado.toAdministrador(), id));
    }
    
    @GetMapping("buscar/{cpf}")
    public AdministradorResponse buscarAdministradorPorCpf(@PathVariable String cpf){
        return new AdministradorResponse(facade.buscarAdministradorPorCpf(cpf));
    }

    @GetMapping("buscar/{nome}")
    public List<AdministradorResponse> buscarAdministradoresPorNome(@PathVariable String nome) {
    return facade.buscarAdministradoresPorNome(nome)
            .stream()
            .map(AdministradorResponse::new)
            .collect(Collectors.toList());
}
}
