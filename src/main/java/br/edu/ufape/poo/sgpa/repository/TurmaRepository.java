package br.edu.ufape.poo.sgpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	List<Turma> findByModalidade(Modalidade modalidade);
	List<Turma> findByInstrutor(Instrutor instrutor);
    List<Turma> findByModalidadeOrInstrutor(Modalidade modalidade, Instrutor instrutor);
    
}
