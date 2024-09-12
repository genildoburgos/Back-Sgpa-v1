package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Administrador;
import br.edu.ufape.poo.sgpa.repository.AdministradorRepository;
import br.edu.ufape.poo.sgpa.controller.dto.request.AdministradorRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository repository;

    public Administrador criarAdministrador(AdministradorRequest novaInstancia){
        
        Administrador administrador = new Administrador();
        administrador.setNome(novaInstancia.getNome());
        administrador.setCpf(novaInstancia.getCpf());
        administrador.setSexo(novaInstancia.getSexo());
        administrador.setDataDeNascimento(novaInstancia.getDataDeNascimento());
        administrador.setTelefone(novaInstancia.getTelefone());
        administrador.setContatoDeEmergencia(novaInstancia.getContatoDeEmergencia());
        administrador.setEmail(novaInstancia.getEmail());
        administrador.setUnidade(novaInstancia.getUnidade());
        

        return repository.save(administrador);
    } 

    public List<Administrador> listarAdministradores() {
        return repository.findAll();
    }
    
    public void deletarAdministrador(Long id){
        buscarAdministradorPorId(id);
        repository.deleteById(id); 
    }

    public Administrador atualizarAdministrador(Long id, AdministradorRequest obj){
        Administrador administradorAntigo = repository.findById(id).orElseThrow(() -> 
        new EntityNotFoundException("Administrador não existe")
    );

        administradorAntigo.setNome(obj.getNome());
        administradorAntigo.setCpf(obj.getCpf());
        administradorAntigo.setSexo(obj.getSexo());
        administradorAntigo.setDataDeNascimento(obj.getDataDeNascimento());
        administradorAntigo.setTelefone(obj.getTelefone());
        administradorAntigo.setContatoDeEmergencia(obj.getContatoDeEmergencia());
        administradorAntigo.setEmail(obj.getEmail());
        administradorAntigo.setUnidade(obj.getUnidade());

        Administrador administradorAtualizado = repository.save(administradorAntigo);
        return administradorAntigo;

        }

        public Administrador buscarAdministradorPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Administrador não encontrado"));
        
        }

   }
