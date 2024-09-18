package br.edu.ufape.poo.sgpa.service;

import br.edu.ufape.poo.sgpa.model.Administrador;

import java.util.List;

public interface AdministradorServiceInterface {
    Administrador criarAdministrador(Administrador novaInstancia);

    List<Administrador> listarAdministradores();

    Administrador buscarAdministradorPorId(Long id);

    void deletarAdministrador(Long id);

    Administrador atualizarAdministrador(Administrador administrador, Long id);

    Administrador buscarAdministradorPorCpf(String cpf); 

    List<Administrador> buscarAdministradoresPorNome(String nome);

    default void validaAdministrador(Administrador administrador) {
        if (administrador.getNome() == null || administrador.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do administrador não pode ser vazio.");
        }
        if (administrador.getEmail() == null || administrador.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email do administrador não pode ser vazio.");
        }
        if (administrador.getCpf() == null || administrador.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF do administrador não pode ser vazio.");
        }
        
        if (administrador.getDataDeNascimento() == null) { 
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }

        if (administrador.getTelefone() == null || administrador.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Telefone do administrador não pode ser vazio.");
        }

        if (administrador.getContatoDeEmergencia() == null || administrador.getContatoDeEmergencia().isEmpty()) {
            throw new IllegalArgumentException("Contato de emergência não pode ser vazio.");
        }
        /*
        if (administrador.getUnidade() == null) {  
            throw new IllegalArgumentException("Unidade do administrador não pode ser nula.");
        } */
    }
}
