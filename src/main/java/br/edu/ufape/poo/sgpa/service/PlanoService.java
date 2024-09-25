package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Plano;
import br.edu.ufape.poo.sgpa.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanoService implements IPlanoService {

    @Autowired
    private PlanoRepository repository;

    @Override
    public List<Plano> listarPlanos(){
        return repository.findAll();
    }

    @Override
    public Plano criarPlano(Plano novoObj){
        validaPlano(novoObj);
        try{
            return repository.save(novoObj);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para criar um plano", e);
        }
    }

    @Override
    public Plano buscarPlano(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano com o id informado não encontrado"));
    }

    @Override
    public void deletarPlano(Long id){
        buscarPlano(id);
        repository.deleteById(id);
    }

    @Override
    public Plano atualizarPlano(Plano plano, Long id){
        if(plano == null){
            throw new IllegalArgumentException("plano não pode ser null.");
        }

        Plano entity = buscarPlano(id);
        validaPlano(plano);

        entity.setValor(plano.getValor());
        entity.setUnidade(plano.getUnidade());
        entity.setPeriodicidade(plano.getPeriodicidade());
        entity.setDataDeVencimento(plano.getDataDeVencimento());

        try{
            return repository.save(entity);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar o plano", e);
        }
    }

}
