package br.edu.ufape.poo.sgpa.facade;

import br.edu.ufape.poo.sgpa.model.Plano;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.service.PlanoService;
import br.edu.ufape.poo.sgpa.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

   

    public Facade(VagaService vagaService, PlanoService planoService) {
        this.vagaService = vagaService;
        this.planoService = planoService;
    }

    // ------------------------ Vaga --------------------------------

    @Autowired
    private final VagaService vagaService;

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


     // ------------------------ Plano --------------------------------

    @Autowired
    private final PlanoService planoService;

    //Listar planos
    public List<Plano> listarPlanosgit (){return planoService.listarPlanos();}

    // Criar plano
    public Plano criarPlano(Plano obj){return planoService.criarPlano(obj);}

    //Deletar plano
    public void deletarPlano(Long id){planoService.deletarPlano(id);}

    //Buscar plano por id
    public Plano buscarPlano(Long id){return planoService.buscarPlano(id);}

    // Atualizar plano
    public Plano atualizarPlano(Plano obj, Long id){return planoService.atualizarPlano(obj, id);}


}
