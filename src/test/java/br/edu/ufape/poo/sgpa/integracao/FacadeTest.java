package br.edu.ufape.poo.sgpa.integracao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import br.edu.ufape.poo.sgpa.exception.InstrutorNaoEncontradoException;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.sgpa.exception.MembroDuplicadoException;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@Transactional
class FacadeTest {

	@Autowired
	Facade facade;

	@Test
	void cadastrarMembroDuplicadoTest() {

		Membro m1 = new Membro("Enzo Henrique", "98765432100", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		Membro m2 = new Membro("Enzo Henrique", "98765432100", "Masculino", LocalDate.of(2000, 2, 21), "8781753241",
				"8781159537", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		MembroDuplicadoException exception = assertThrows(MembroDuplicadoException.class, () -> {
			facade.cadastrarMembro(m1); // Cadastra o primeiro membro
			facade.cadastrarMembro(m2); // Tenta cadastrar o segundo membro com CPF duplicado
		});

		assertEquals(m1.getCpf(), m2.getCpf());
		assertEquals("Existe no sistema um membro com o CPF informado", exception.getMessage());
	}

	@Test
	void atualizarInstrutorInexistenteTest() {
		Instrutor instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
				"(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);

		// Captura da exceção ResponseStatusException
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			facade.atualizarInstrutor(instrutor, 1L);
		});

		// Printando a mensagem da exceção
		System.out.println(exception.getMessage());

		// Verificando se o status HTTP e a mensagem da exceção estão corretos
		assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
		assertEquals("404 NOT_FOUND \"Instrutor com o id informado não encontrado\"", exception.getMessage());
	}




}
