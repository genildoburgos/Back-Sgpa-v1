package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.edu.ufape.poo.sgpa.exception.InstrutorNaoEncontradoException;

import java.util.List;

@Service
public class InstrutorService implements InstrutorServiceInterface {
    @Autowired
    private InstrutorRepository repository;

    @Override
    public Instrutor criarInstrutor(Instrutor obj){
        try{
            validaInstrutor(obj);
            return repository.save(obj);
        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para criar um instrutor", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar instrutor", e);
        }
    }

    @Override
    public List<Instrutor> listarInstrutores(){
        return repository.findAll();
    }

    @Override
    public Instrutor buscarInstrutor(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrutor com o id informado não encontrado"));
    }

    @Override
    public void deletarIntrutor(Long id){
        buscarInstrutor(id);
        try{
            repository.deleteById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar instrutor", e);
        }
    }

    @Override
    public Instrutor atualizarInstrutor(Instrutor instrutor, Long id) throws InstrutorNaoEncontradoException {
        if (instrutor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Instrutor não pode ser null.");
        }

        // Verificando se o instrutor existe
        Instrutor entity = buscarInstrutor(id);
        if (entity == null) {
            throw new InstrutorNaoEncontradoException();
        }

        // Atualizando os campos do instrutor existente
        entity.setClt(instrutor.getClt());
        entity.setHorariosDeTrabalho(instrutor.getHorariosDeTrabalho());
        entity.setModalidades(instrutor.getModalidades());
        entity.setUnidades(instrutor.getUnidades());
        entity.setNome(instrutor.getNome());
        entity.setCpf(instrutor.getCpf());
        entity.setDataDeNascimento(instrutor.getDataDeNascimento());
        entity.setTelefone(instrutor.getTelefone());
        entity.setEmail(instrutor.getEmail());
        entity.setSexo(instrutor.getSexo());
        entity.setContatoDeEmergencia(instrutor.getContatoDeEmergencia());

        try {
            validaInstrutor(entity); // Validação dos dados
            return repository.save(entity); // Salvando no repositório
        } catch (IllegalArgumentException e) {
            // Tratamento de dados inválidos
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos para atualizar o instrutor", e);
        }
    }


    // buscar alem do C.R.U.D

    @Override
    public Instrutor buscarInstrutorPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrutor com o CPF " + cpf + " não encontrado"));
    }

    @Override
    public List<Instrutor> buscarInstrutoresPorNome(String nome) {
        return repository.findByNomeContainsIgnoreCaseOrderByNome(nome);
    }

}
