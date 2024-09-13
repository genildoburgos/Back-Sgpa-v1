package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VagaService implements VagaServiceInterface {
    @Autowired
    private VagaRepository repository;

    @Override
    public List<Vaga> listarVagas(){
        return repository.findAll();
    }

    @Override
    public Vaga criarVaga(Vaga novaInstancia){
        validaVaga(novaInstancia);
        try{
            return repository.save(novaInstancia);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para criar uma vaga", e);
        }
    }

    @Override
    public void deletarVaga(Long id) {
        buscarVagaPorId(id);
        try{
            repository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar a vaga", e);
        }
    }

    @Override
    public Vaga atualizarVaga(Vaga vaga, Long id) {
        Vaga entity = buscarVagaPorId(id);
        validaVaga(vaga);
        entity.setCapacidade(vaga.getCapacidade());
        entity.setQuantidade(vaga.getQuantidade());
        try{
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para atualizar a vaga", e);
        }
    }

    @Override
    public Vaga buscarVagaPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Vaga não encontrada com o id " + id));
    }

}
