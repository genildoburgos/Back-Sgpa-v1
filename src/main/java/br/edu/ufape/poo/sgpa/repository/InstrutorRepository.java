package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.model.SlotHorario;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
/*
    //Ideias de assinatura de metodos

    List<Instrutor> findByModalidadesContainingOrderByNome(Modalidade modalidade);

    List<Instrutor> findByUnidadeContainingOrderByNome(Unidade unidade);

    Optional<Instrutor> findByClt(String clt);

    Optional<Instrutor> findByNomeIgnoreCaseOrderByNome(String nome);*/
    List<Instrutor> findByNomeContainsIgnoreCaseOrderByNome(String nome);
/*
    Optional<Instrutor> findByEmail(String email);

    List<Instrutor> findBySexoOrderByNome(String sexo);

    Optional<Instrutor> findByTelefone(String telefone);
    */
    Optional<Instrutor> findByCpf(String cpf);
/*
    // Encontra instrutores disponíveis um dia da semana
    List<Instrutor> findByHorariosDeTrabalho_DiaDaSemana(DiaDaSemana diaDaSemana);

    // Encontra instrutores disponíveis em um intervalo de horário específico em um dia da semana.
    List<Instrutor> findByHorariosDeTrabalho_DiaDaSemanaAndHorariosDeTrabalho_HorarioInicialLessThanEqualAndHorariosDeTrabalho_HorarioFinalGreaterThanEqual(
            DiaDaSemana diaDaSemana, LocalTime horarioInicial, LocalTime horarioFinal
    );

    // Encontra instrutores disponíveis em um horário específico em um dia da semana.
    List<Instrutor> findByHorariosDeTrabalho_DiaDaSemanaAndHorariosDeTrabalho_HorarioInicialLessThanEqualAndHorariosDeTrabalho_HorarioFinalGreaterThanEqual(
            DiaDaSemana diaDaSemana, LocalTime horario
    );
*/
}
