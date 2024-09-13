package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.controller.dto.request.VagaRequest;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.save(novaInstancia);
    }

    @Override
    public void deletarVaga(Long id) {
        buscarVagaPorId(id);
        repository.deleteById(id);
    }

    @Override
    public Vaga atualizarVaga(Long id, Vaga vaga) {
        return repository.save(vaga);
    }

    @Override
    public Vaga buscarVagaPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Vaga não encotrada"));
    }
}
