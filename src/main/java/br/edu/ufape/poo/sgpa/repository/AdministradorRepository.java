package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository; 

import java.util.List;
import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
     
    Optional<Administrador> findByCpf(String cpf);
    List<Administrador> findByNomeContainsIgnoreCaseOrderByNome(String nome);
 }