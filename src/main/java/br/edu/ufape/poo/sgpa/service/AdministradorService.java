package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Administrador;
import br.edu.ufape.poo.sgpa.repository.AdministradorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdministradorService implements IAdministradorService {
    @Autowired
    private AdministradorRepository repository;

    @Override
    public List<Administrador> listarAdministradores() {
        return repository.findAll();
    }

    @Override
    public Administrador criarAdministrador(Administrador novaInstancia) {
        validaAdministrador(novaInstancia);
        try {
            return repository.save(novaInstancia);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para criar um administrador", e);
        }
    }

    @Override
    public Administrador buscarAdministradorPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrador não encontrado com o id " + id));
    }

    @Override
    public void deletarAdministrador(Long id) {
        buscarAdministradorPorId(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar o administrador", e);
        }
    }

    @Override
    public Administrador atualizarAdministrador(Administrador administrador, Long id) {
        Administrador entity = buscarAdministradorPorId(id);
        validaAdministrador(administrador);

        entity.setNome(administrador.getNome());
        entity.setEmail(administrador.getEmail());
        entity.setCpf(administrador.getCpf());
        entity.setDataDeNascimento(administrador.getDataDeNascimento());
        entity.setTelefone(administrador.getTelefone());
        entity.setContatoDeEmergencia(administrador.getContatoDeEmergencia());
        entity.setUnidade(administrador.getUnidade());  

        try {
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar o administrador", e);
        }
    }

    @Override
    public Administrador buscarAdministradorPorCpf(String cpf) { 
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador com o CPF " + cpf + " não encontrado"));
    }

    @Override
    public List<Administrador> buscarAdministradoresPorNome(String nome) {
        return repository.findByNomeContainsIgnoreCaseOrderByNome(nome);
    }
}
