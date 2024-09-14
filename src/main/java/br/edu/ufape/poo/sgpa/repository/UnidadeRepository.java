package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    Optional<Unidade> findByNomeIgnoreCase(String nome);
    Optional<Unidade> findByCnpj(String cnpj);
    Optional<Unidade> findByNomeIgnoreCaseAndCnpj(String nome, String cnpj);
    Optional<Unidade> findByContato(String contato);
    Optional<Unidade> findByEmail(String email);
    Optional<Unidade> findByEndereco(Endereco endereco);
    List<Unidade> findByNomeContainingIgnoreCase(String nome);
    List<Unidade> findByPlanos(Plano plano);
    List<Unidade> findByInstrutores(Instrutor instrutor);
    List<Unidade> findByMembro(Membro membro);
    List<Unidade> findBySegmento(Segmento segmento);
    List<Unidade> findByTurmas(Turma turma);
    List<Unidade> findByHorarioDeFuncionamento(SlotHorario horario);
    List<Unidade> findByAdministrador(Administrador administrador);
    List<Unidade> findBySalas(Sala sala);
}
