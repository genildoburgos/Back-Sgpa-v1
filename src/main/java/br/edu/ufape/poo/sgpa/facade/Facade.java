package br.edu.ufape.poo.sgpa.facade;

import br.edu.ufape.poo.sgpa.controller.dto.request.VagaRequest;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    private final VagaService vagaService;

    public Facade(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    // ------------------------ Vaga --------------------------------

    // Listar vagas
    public List<Vaga> listarVagas() {return vagaService.listarVagas();}

    // Criar nova vaga
    public Vaga criarVaga(Vaga novoObj) {return vagaService.criarVaga(novoObj);}

    // Deletar vaga
    public void deletarVaga(Long id) {vagaService.deletarVaga(id);}

    // Burcar vaga por Id
    public Vaga buscarVagaPorId(Long id){return vagaService.buscarVagaPorId(id);}

    // Atulizar vaga
    public Vaga atualizarVaga(Vaga obj, Long id) {return vagaService.atualizarVaga(obj, id);}
}
