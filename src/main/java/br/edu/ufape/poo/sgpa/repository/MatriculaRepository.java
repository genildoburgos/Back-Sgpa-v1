package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByMembro(Membro membro);
    List<Matricula> findByDataDeMatricula(LocalDate dataDeMatricula);
    List<Matricula> findBydataDeExpiracao(LocalDate dataDeExpiracao);
    List<Matricula> findByStatusDaMatricula(StatusDaMatricula status);
    List<Matricula> findByTurma(Turma turma);


}
