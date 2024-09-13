package br.edu.ufape.poo.sgpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.poo.sgpa.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long>{
	
	void deleteByCpf(String cpf);
    Optional<Membro> findByCpfOrderByNome(String cpf);
    Optional<Membro> findByNumeroDeMatriculaOrderByNome(String numeroDeMatricula);
    List<Membro> findByNomeContainingIgnoreCaseOrderByNome(String nome);
    List<Membro> findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNome(String cpf, String numeroDeMatricula, String nome);
    
}
