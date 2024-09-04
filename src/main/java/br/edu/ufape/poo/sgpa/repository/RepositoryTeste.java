package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.modeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTeste extends JpaRepository<modeTest, Long> {

}
