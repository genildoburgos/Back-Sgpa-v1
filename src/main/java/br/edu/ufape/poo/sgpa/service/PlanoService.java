package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository repository;

    public List<Plano> listarPlanos(){
        return repository.findAll();
    }

    public Plano criarPlano(Plano novoObj){
        return repository.save(novoObj);
    }

    public Plano buscarPlano(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Plano com o id informado não encontrado"));
    }

    public void deletarPlano(Long id){
        buscarPlano(id);
        repository.deleteById(id);
    }

    public Plano atualizarPlano(Long id, Plano novoObj){
        Plano planoAntigo = buscarPlano(id);

        if(novoObj.getDataDeVencimento() != null){
            planoAntigo.setDataDeVencimento(novoObj.getDataDeVencimento());
        }

        if(novoObj.getPeriodicidade() != null){
            planoAntigo.setPeriodicidade(novoObj.getPeriodicidade());
        }

        if(novoObj.getUnidade() != null){
            planoAntigo.setUnidade(novoObj.getUnidade());
        }
        if(novoObj.getValor() != 0.0){
            planoAntigo.setValor(novoObj.getValor());
        }

        return repository.save(planoAntigo);
    }

}
