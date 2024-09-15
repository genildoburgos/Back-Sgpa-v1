package br.edu.ufape.poo.sgpa.facade;

import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    public Facade(MembroService membroService, PlanoService planoService, VagaService vagaService, InstrutorService instrutorService, UnidadeService unidadeService) {
		this.membroService = membroService;
        this.planoService = planoService;
        this.vagaService = vagaService;
        this.instrutorService = instrutorService;
        this.unidadeService = unidadeService;
    }
    
    // ------------------------ Membro --------------------------------
    
    @Autowired
    private final MembroService membroService;
    
    public List<Membro> listarMembros () {return membroService.listarMembros();}

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



    //---------------------- Instrutor ---------------------------
    @Autowired
    private final InstrutorService instrutorService;

    //Listar instrutor
    public List <Instrutor> listarInstrutores() {return instrutorService.listarInstrutores();}

    //criar instrutor
    public Instrutor criarInstrutor(Instrutor novoInstrutor) {return instrutorService.criarInstrutor(novoInstrutor);}

    // deletar instrutor
    public void deletarInstrutor(Long id){instrutorService.deletarIntrutor(id);}

    //buscar instrutor por id
    public Instrutor buscarInstrutor(Long id){return instrutorService.buscarInstrutor(id);}

    //atualizar instrutor
    public Instrutor atualizarInstrutor(Instrutor instrutor, Long id){return instrutorService.atualizarInsturor(instrutor, id);}


    //------------------- Unidade --------------------
    @Autowired
    private final UnidadeService unidadeService;
    //listar unidades
    public List<Unidade> listarUnidades() {return unidadeService.listarUnidades();}

    //criar unidade
    public Unidade criarUnidade(Unidade unidade) {return unidadeService.criarUnidade(unidade);}

    //deletar unidade
    public void deletarUnidade(Long id){unidadeService.deletarUnidade(id);}

    //buscar unidade por id
    public Unidade buscarUnidade(Long id){return unidadeService.buscarUnidade(id);}

    //atualizar unidade
    public Unidade atualizarUnidade(Unidade unidade, Long id){return unidadeService.atualizarUnidade(unidade, id);}

}
