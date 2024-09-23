package br.edu.ufape.poo.sgpa.unitario;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.sgpa.exception.InstrutorNaoEncontradoException;
import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;
import br.edu.ufape.poo.sgpa.service.InstrutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
public class InstrutorServiceTest {

    @Autowired
    private InstrutorService instrutorService;

    @Test
    public void criarInstrutorCorretamente() {
        // Cenário
        Unidade unidade = new Unidade("Strong Delicate",
                "12.345.678/0001-90", "", Arrays.asList(new SlotHorario(LocalTime.of(8, 0, 0), LocalTime.of(12, 0, 0), DiaDaSemana.SEGUNDA)),
                "contato@strongdelicate.com", null, null, Segmento.ESCOLA_DE_GINASTICA,
                new Endereco("Avenida Paulista", "8", "Andar 9", "Vila", "São Paulo", "SP", "162664664", null),
                null, null, null, null);

        String nome = "Ravenna";
        String cpf = "123456789"; // CPF único
        String sexo = "Feminino";
        LocalDate dataDeNascimento = LocalDate.of(1998, 7, 22);
        String telefone = "(11) 98765-4321";
        String contatoDeEmergencia = "(11) 91234-5678";
        String email = "ravenna@example.com";
        List<Unidade> unidades = Arrays.asList(unidade);
        List<Modalidade> modalidades = Arrays.asList(Modalidade.BALE, Modalidade.YOGA, Modalidade.PILATES);
        List<SlotHorario> horariosDeTrabalho = Arrays.asList(new SlotHorario(LocalTime.of(8, 0, 0), LocalTime.of(12, 0, 0), DiaDaSemana.SEGUNDA));
        String clt = "123456789";
        int idade = 26;

        Instrutor instrutor = new Instrutor(nome, cpf, sexo, dataDeNascimento, telefone, contatoDeEmergencia, email, unidades, modalidades, horariosDeTrabalho, clt, idade);

        // Ação
        Instrutor instrutorCriado = instrutorService.criarInstrutor(instrutor);

        // Resultado
        assertNotNull(instrutorCriado);
        assertEquals(nome, instrutorCriado.getNome());
        assertEquals(cpf, instrutorCriado.getCpf());
        assertEquals(telefone, instrutorCriado.getTelefone());
    }

    @Test
    public void encontrarInstrutorPorCpf() {
        // Cenário
        Instrutor instrutor = new Instrutor("Ravenna", "000", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        instrutorService.criarInstrutor(instrutor);

        // Ação
        Instrutor instrutorEncontrado = instrutorService.buscarInstrutorPorCpf("000");

        // Resultado
        assertNotNull(instrutorEncontrado);
        assertEquals(instrutor.getCpf(), instrutorEncontrado.getCpf());
    }

    @Test
    public void encontrarInstrutorPorId() {
        // Cenário
        Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        Instrutor instrutorCriado = instrutorService.criarInstrutor(instrutor);
        Long instrutorId = instrutorCriado.getId();

        // Ação
        Instrutor instrutorEncontrado = instrutorService.buscarInstrutor(instrutorId);

        // Resultado
        assertNotNull(instrutorEncontrado);
        assertEquals(instrutorCriado.getId(), instrutorEncontrado.getId());
    }

    @Test
    public void atualizarInstrutor() throws InstrutorNaoEncontradoException {
        // Cenário
        Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        Instrutor instrutorCriado = instrutorService.criarInstrutor(instrutor);

        instrutorCriado.setNome("Ravenna Silva");
        instrutorCriado.setTelefone("(11) 99999-8888");

        // Ação
        Instrutor instrutorAtualizado = instrutorService.atualizarInstrutor(instrutorCriado, 1L); // Atualizando o objeto correto

        // Resultado
        assertNotNull(instrutorAtualizado);
        assertEquals("Ravenna Silva", instrutorAtualizado.getNome());
        assertEquals("(11) 99999-8888", instrutorAtualizado.getTelefone());
    }

    @Test
    public void atualizarInstrutorIdInexistente() {
        // Cenário
        Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        instrutorService.criarInstrutor(instrutor);

        instrutor.setNome("Ravenna Silva");
        instrutor.setTelefone("(11) 99999-8888");

        // Ação e Resultado
        assertThrows(ResponseStatusException.class, () -> {
            instrutorService.atualizarInstrutor(instrutor, 10L); // Tentando atualizar com um ID que não existe
        });
    }


    @Test
    public void listarInstrutores() {
        // Cenário
        Instrutor instrutor1 = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        Instrutor instrutor2 = new Instrutor("Carlos", "987654321", "Masculino", LocalDate.of(1995, 5, 15),
                "(11) 91234-5678", "(11) 98765-4321", "carlos@example.com", null, null, null, "987654321", 29);

        instrutorService.criarInstrutor(instrutor1);
        instrutorService.criarInstrutor(instrutor2);

        // Ação
        List<Instrutor> instrutores = instrutorService.listarInstrutores();

        // Resultado
        assertNotNull(instrutores);
        assertTrue(instrutores.size() >= 2);
        assertTrue(instrutores.stream().anyMatch(i -> i.getNome().equals("Ravenna")));
        assertTrue(instrutores.stream().anyMatch(i -> i.getNome().equals("Carlos")));
    }

    @Test
    public void removerInstrutor() {
        // Cenário
        Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        Instrutor instrutorCriado = instrutorService.criarInstrutor(instrutor);
        Long instrutorId = instrutorCriado.getId();

        // Ação
        instrutorService.deletarIntrutor(instrutorId);

        // Resultado
        assertThrows(Exception.class, () -> instrutorService.buscarInstrutor(instrutorId));
    }

    @Test
    public void criarInstrutorComDadosInvalidos() {
        Instrutor instrutor = new Instrutor(); // Suponha que isso resulte em dados inválidos

        assertThrows(ResponseStatusException.class, () -> {
            instrutorService.criarInstrutor(instrutor);
        });
    }

    @Test
    public void buscarInstrutorPorIdInexistente() {
        Long idInexistente = 999L; // ID que não existe

        assertThrows(ResponseStatusException.class, () -> {
            instrutorService.buscarInstrutor(idInexistente);
        });
    }

    @Test
    public void deletarInstrutorInexistente() {
        Long idInexistente = 999L; // ID que não existe

        assertThrows(ResponseStatusException.class, () -> {
            instrutorService.deletarIntrutor(idInexistente);
        });
    }

    @Test
    public void atualizarInstrutorComDadosInvalidos() {
        Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        instrutorService.criarInstrutor(instrutor);

        // Criar um instrutor com dados inválidos para atualização
        Instrutor instrutorInvalido = new Instrutor(); // Dados inválidos

        assertThrows(ResponseStatusException.class, () -> {
            instrutorService.atualizarInstrutor(instrutorInvalido, instrutor.getId());
        });
    }


}
