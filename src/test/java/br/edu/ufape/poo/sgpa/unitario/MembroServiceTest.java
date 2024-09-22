package br.edu.ufape.poo.sgpa.unitario;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.CpfInvalidoException;
import br.edu.ufape.poo.sgpa.exception.DataForaDaFaixaException;
import br.edu.ufape.poo.sgpa.exception.MembroDuplicadoException;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;
import br.edu.ufape.poo.sgpa.exception.MembroMenorDeIdadeException;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Responsavel;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import br.edu.ufape.poo.sgpa.service.IMembroService;

@SpringBootTest
class MembroServiceTest {

	@Autowired
	private IMembroService membroService;

	@Test
	void cadastrarMembroDuplicadoTest() {

		Membro membro1 = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21),
				"8798175324", "9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		Membro membro2 = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21),
				"8781753241", "8781159537", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		MembroDuplicadoException exception = assertThrows(MembroDuplicadoException.class, () -> {
			membroService.cadastrarMembro(membro1);
			membroService.cadastrarMembro(membro2);
		});

		assertEquals(membro1.getCpf(), membro2.getCpf());
		assertEquals("Existe no sistema um membro com o CPF informado", exception.getMessage());
	}

	@Test
	void cadastrarMembroComCpfNulo() {
		Membro membro = new Membro("Enzo Henrique", null, "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		CampoObrigatorioNuloException exception = assertThrows(CampoObrigatorioNuloException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("Existe campos obrigatórios que não foram preenchidos", exception.getMessage());

	}

	@Test
	void cadastrarMembroComNomeNulo() {
		Membro membro = new Membro(null, "16623014489", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		CampoObrigatorioNuloException exception = assertThrows(CampoObrigatorioNuloException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("Existe campos obrigatórios que não foram preenchidos", exception.getMessage());

	}

	@Test
	void cadastrarMembroComDataDeNascimentoNula() {
		Membro membro = new Membro("Enzo Henrique", "16623014489", "Masculino", null, "8798175324", "9879811595",
				"enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		CampoObrigatorioNuloException exception = assertThrows(CampoObrigatorioNuloException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("Existe campos obrigatórios que não foram preenchidos", exception.getMessage());

	}

	@Test
	void cadastrarMembroComTelefoneNulo() {
		Membro membro = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21), null,
				"9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		CampoObrigatorioNuloException exception = assertThrows(CampoObrigatorioNuloException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("Existe campos obrigatórios que não foram preenchidos", exception.getMessage());

	}

	@Test
	void cadastrarMembroComContatoDeEmergenciaNulo() {
		Membro membro = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				null, "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 21);

		CampoObrigatorioNuloException exception = assertThrows(CampoObrigatorioNuloException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("Existe campos obrigatórios que não foram preenchidos", exception.getMessage());

	}

	@Test
	void cadastrarMembroMenorDeIdadeComResponsavelNulo() {

		Membro membro = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "123M34", null, StatusDePagamento.EFETUADO, 15);

		MembroMenorDeIdadeException exception = assertThrows(MembroMenorDeIdadeException.class, () -> {
			membroService.cadastrarMembro(membro);
		});

		assertEquals("O membro é menor de idade, precisa de um responsável", exception.getMessage());

	}

	@Test
	void cadastrarMembroMenorDeIdadeComResponsavel() {

		Responsavel responsavel = new Responsavel("Maria Aparecida", "Mãe", "8781159537");

		Membro membro = new Membro("Enzo Henrique", "16623014489", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "123M34", responsavel, StatusDePagamento.EFETUADO, 15);

		assertDoesNotThrow(() -> {
			membroService.cadastrarMembro(membro);
		});
	}

	@Test
	void deletarMembroInexistentePorCpfTest() {

		MembroNaoExisteException exception = assertThrows(MembroNaoExisteException.class, () -> {
			membroService.deletarMembroPorCpf("16624015589");
		});

		assertEquals("O membro não está cadastrado no sistema", exception.getMessage());

	}
	
	@Test
	void gerarMatriculaTest() throws CampoObrigatorioNuloException, CpfInvalidoException, MembroDuplicadoException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException {
	    Membro membro = new Membro("Enzo Henrique", "98765432100", "Masculino", LocalDate.of(2000, 2, 21),
	            "8798175324", "9879811595", "enzoh@gmail.com", null, null, null, StatusDePagamento.EFETUADO, 21);
	    
	    // Cadastrar o membro para gerar uma matrícula
	    membroService.cadastrarMembro(membro);

	    String matriculaGerada = membro.getNumeroDeMatricula();
	    
	    // Verifica se a matrícula gerada começa com "MA" e tem 12 caracteres no total (2 para "MA" + 10 números)
	    assertTrue(matriculaGerada.startsWith("MA"));
	    assertEquals(12, matriculaGerada.length());

	}

}
