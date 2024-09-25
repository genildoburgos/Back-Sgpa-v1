package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;

import java.time.LocalDate;
import java.util.List;

public interface IMatriculaServiceInterface {
    Matricula criarMatricula(Matricula matricula) throws MembroNaoExisteException, TurmaNaoExisteException;
    List <Matricula> listarMatriculas();
    Matricula buscarMatricula(Long id);
    void deletarMatricula(Long id);
    Matricula atualizarMatricula(Matricula matricula, Long id);

    List<Matricula> buscarMatriculasPorMembro(Membro membro);
    List<Matricula> buscarPorDataExpiracao(LocalDate dataExpiracao);
    List<Matricula> buscarPorDataDeMatricula(LocalDate dataExpiracao);
    List<Matricula> buscarPorStatus(StatusDaMatricula status);

    void ativarMatricula(Matricula matricula);

    void suspenderMatricula(Matricula matricula);

    boolean estaExpirada(Matricula matricula);

	boolean validarMatricula(Matricula matricula);
    
}
