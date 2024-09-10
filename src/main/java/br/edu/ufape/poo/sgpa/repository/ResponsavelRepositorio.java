package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponsavelRepositorio extends JpaRepository<Responsavel, Long> {
/*
    List<Responsavel> findByNomeIgnoreCaseOrderByNome(String nome); // busca por nome e retorna uma lista de responsaveis ordenada por nome

    List<Responsavel> findByNomeContainingIgnoreCaseOrderByNome(String infixo); // busca por uma parte do nome e retorna uma lista

    Optional<Responsavel> findByNomeIgnoreCase(String nome); //busca pelo nome e retorna apenas um responsavel

    Optional<Responsavel> findByNomeContainingIgnoreCase(String infixo); //busca por parte do nome e retorna apenas um responsavel

    List<Responsavel> findByParentescoIgnoreCase(String parentesco); //busca por parentesco

    Optional<Responsavel> findByTelefone(String telefone); //busca por telefone

    List<Responsavel> findByNomeIgnoreCaseAndParentescoIgnoreCase(String nome, String parentesco); //busca por nome e parentesco
*/
}
