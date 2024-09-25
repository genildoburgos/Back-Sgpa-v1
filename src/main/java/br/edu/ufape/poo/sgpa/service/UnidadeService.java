package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UnidadeService implements IUnidadeService{
    @Autowired
    private UnidadeRepository repository;

    @Override
    public Unidade criarUnidade(Unidade obj) {
        try {
            validarUnidade(obj);
            return repository.save(obj);

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para criar a unidade", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar a unidade", e);
        }
    }
    @Override
    public List<Unidade> listarUnidades() {
        return repository.findAll();
    }

    @Override
    public Unidade buscarUnidade(Long id) {
            return repository.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade com o id informado não encontrado"));
    }

    @Override
    public void deletarUnidade(Long id) {
        buscarUnidade(id);
        try{
            repository.deleteById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar unidade", e);
        }
    }

    @Override
    public Unidade atualizarUnidade(Unidade obj, Long id) {
        try {
            Unidade entity = repository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade com o id informado não encontrada"));

            entity.setNome(obj.getNome());
            entity.setCnpj(obj.getCnpj());
            entity.setContato(obj.getContato());
            entity.setEmail(obj.getEmail());
            entity.setEndereco(obj.getEndereco());
            entity.setSalas(obj.getSalas());
            entity.setSegmento(obj.getSegmento());
            entity.setPlanos(obj.getPlanos());
            entity.setInstrutores(obj.getInstrutores());
            entity.setMembro(obj.getMembro());
            entity.setTurmas(obj.getTurmas());
            entity.setHorarioDeFuncionamento(obj.getHorarioDeFuncionamento());
            entity.setAdministrador(obj.getAdministrador());


            validarUnidade(entity);
            return repository.save(entity);

        } catch (IllegalArgumentException e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar a unidade", e);
        } catch (ResponseStatusException e) {

            throw e;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar a unidade", e);
        }
    }

    // buscar alem do C.R.U.D

    @Override
    public Unidade buscarUnidadePorNome(String nome) {
        return repository.findByNomeIgnoreCaseOrderByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade com o nome: " + nome + " não encontrada"));
    }

    @Override
    public List<Unidade> buscarUnidadesPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCaseOrderByNome(nome);
    }

    @Override
    public Unidade buscarUnidadePorCnpj(String cnpj) {
        return repository.findByCnpj(cnpj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade com o cnpj " + cnpj + " não encontrada"));
    }

}
