package br.edu.ufape.poo.sgpa.unitario.vaga;


import br.edu.ufape.poo.sgpa.model.Vaga;
import br.edu.ufape.poo.sgpa.service.VagaService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class VagaServiceTeste {

    @Autowired
    private VagaService vagaService;

    @Test
    public void criarVagaCorretamente(){
        //cenario
        int capacidade =10;
        int quantidade = 10;
        //acao
        Vaga vaga = new Vaga(capacidade, quantidade);
        Vaga vagaCriada = vagaService.criarVaga(vaga);
        // Resultado
        assertNotNull(vagaCriada); // Verifica se a vaga foi criada
        assertEquals(capacidade, vagaCriada.getCapacidade());
        assertEquals(quantidade, vagaCriada.getQuantidade());

    }

    @Test
    public void deletarVaga(){
        //cenario
        int capacidade =10;
        int quantidade = 10;
        Vaga vaga = new Vaga(capacidade, quantidade);
        Vaga vagaCriada = vagaService.criarVaga(vaga);
        //acao
        vagaService.deletarVaga(vaga.getId());
        // resultado
        assertThrows(EntityNotFoundException.class, () -> vagaService.buscarVagaPorId(vagaCriada.getId()));
    }

    @Test
    public void criarVagaComCapacidadeEQuantidadeErrada(){
        //cenario
        int capacidade =5;
        int quantidade = 10;
        //acao e resultado
        Vaga vaga = new Vaga(capacidade, quantidade);
        assertThrows(IllegalArgumentException.class, () -> vagaService.criarVaga(vaga));
    }

    @Test
    public void criarVagaComValoresDeQuantidadeECapacidadeZerados(){
        //cenario
        int capacidade =0;
        int quantidade = 0;
        //acao e resultado
        Vaga vaga = new Vaga(capacidade, quantidade);
        assertThrows(IllegalArgumentException.class, () -> vagaService.criarVaga(vaga));
    }

    @Test
    public void buscarVagaPorId(){
        //cenario
        int capacidade =10;
        int quantidade = 10;
        //acao
        Vaga vaga = new Vaga(capacidade, quantidade);
        vagaService.criarVaga(vaga);
        Vaga vagaBuscada = vagaService.buscarVagaPorId(vaga.getId());
        //resultado
        assertNotNull(vagaBuscada);
        assertEquals(vagaBuscada.getId(), vaga.getId());
    }

    @Test
    public void atualizarCapacidadeDeVaga(){
        //cenario
        int capacidade =10;
        int quantidade = 10;
        Vaga vaga = new Vaga(capacidade, quantidade);
        Vaga vagaAntiga = vagaService.criarVaga(vaga);
        // acao
        int novaCapacidade = 20;
        vaga.setCapacidade(novaCapacidade);
        Vaga vagaAtualizada = vagaService.atualizarVaga(vaga, vaga.getId());
        //resultado
        assertNotNull(vagaAtualizada);
        assertEquals(vagaAtualizada.getCapacidade(), novaCapacidade);
    }
}
