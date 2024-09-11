package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.controller.dto.request.VagaRequest;
import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {
    @Autowired
    private VagaRepository repository;

    public List<Vaga> listarVagas(){
        return repository.findAll();
    }

    public Vaga criarVaga(VagaRequest novaInstancia){
        // Converter VagaRequest para Vagas
        Vaga vaga = new Vaga();
        vaga.setCapacidade(novaInstancia.getCapacidade());
        vaga.setQuantidade(novaInstancia.getQuantidade());

        return repository.save(vaga);
    }

    public void deletarVaga(Long id) {
        buscarVagaPorId(id);
        repository.deleteById(id);
    }

    public Vaga atualizarVaga(Long id, VagaRequest obj) {
        Vaga vagaAntiga = buscarVagaPorId(id);

        vagaAntiga.setQuantidade(obj.getQuantidade());
        vagaAntiga.setCapacidade(obj.getCapacidade());

        Vaga vagaAtualizada = repository.save(vagaAntiga);
        return vagaAntiga;
    }

    public Vaga buscarVagaPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Vaga não encotrada"));
    }
}
