package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.PlanoRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.PlanoResponse;
import br.edu.ufape.poo.sgpa.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/plano")
public class PlanoController {

    @Autowired
    private Facade facade;

    @GetMapping
    public List<PlanoResponse> listarPlanos() {
        return facade.listarPlanos()
                .stream()
                .map(PlanoResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanoResponse criarPlano(@RequestBody PlanoRequest novoObj){
        return new PlanoResponse(facade.criarPlano(novoObj.toPlano()));
    }

    @GetMapping("buscar/{id}")
    public PlanoResponse buscarPorId(@PathVariable Long id) {
        return new PlanoResponse(facade.buscarPlano(id));
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPlano(@PathVariable Long id){
        facade.deletarPlano(id);
    }

    @PutMapping("atualizar/{id}")
    public PlanoResponse atualizarPlano(@RequestBody PlanoRequest planoAtualizado, @PathVariable Long id){
        return new PlanoResponse(facade.atualizarPlano(planoAtualizado.toPlano(), id));
    }
}
