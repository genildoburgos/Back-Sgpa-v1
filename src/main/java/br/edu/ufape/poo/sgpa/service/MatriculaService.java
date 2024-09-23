package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.repository.MatriculaRepository;
import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatriculaService implements IMatriculaServiceInterface{
    @Autowired
    private MatriculaRepository repository;

    @Override
    public Matricula criarMatricula(Matricula matricula) {
        try {
            validarMatricula(matricula);
            return repository.save(matricula);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para criar matrícula", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar matrícula", e);
        }
    }

    @Override
    public List<Matricula> listarMatriculas() {
        return repository.findAll();
    }

    @Override
    public Matricula buscarMatricula(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula com o id informado não encontrada"));
    }

    @Override
    public void deletarMatricula(Long id) {
        buscarMatricula(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar Matrícula", e);
        }
    }

    @Override
    public Matricula atualizarMatricula(Matricula matricula, Long id) {
        Matricula matriculaExistente = buscarMatricula(id);
        try {
            validarMatricula(matricula);
            matriculaExistente.setDataDeMatricula(matricula.getDataDeMatricula());
            matriculaExistente.setDataDeExpiracao(matricula.getDataDeExpiracao());
            matriculaExistente.setStatusDaMatricula(matricula.getStatusDaMatricula());
            matriculaExistente.setMembro(matricula.getMembro());
            matriculaExistente.setTurma(matricula.getTurma());
            return repository.save(matriculaExistente);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar matrícula", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar matrícula", e);
        }
    }

    @Override
    public List<Matricula> buscarMatriculasPorMembro(Membro membro) {
        return repository.findByMembro(membro);
    }

    @Override
    public List<Matricula> buscarPorDataExpiracao(LocalDate dataExpiracao) {
        return repository.findBydataDeExpiracao(dataExpiracao);
    }

    @Override
    public List<Matricula> buscarPorDataDeMatricula(LocalDate dataMatricula) {
        return repository.findByDataDeMatricula(dataMatricula);
    }

    @Override
    public List<Matricula> buscarPorStatus(StatusDaMatricula status) {
        return repository.findByStatusDaMatricula(status);
    }

    @Override
    public void ativarMatricula(Matricula matricula) {
        matricula.setStatusDaMatricula(StatusDaMatricula.ATIVA);
    }

    @Override
    public void suspenderMatricula(Matricula matricula) {
        matricula.setStatusDaMatricula(StatusDaMatricula.SUSPENSA);
    }

    @Override
    public boolean estaExpirada(Matricula matricula) {
        return LocalDate.now().isAfter(matricula.getDataDeExpiracao());
    }
}
