package br.edu.ufape.poo.sgpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.sgpa.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	
	Optional<Sala> findByBlocoAndNumero(String bloco, String numero);
	List<Sala> findByBloco(String bloco);

}
