package br.edu.ufape.poo.sgpa.integracao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import br.edu.ufape.poo.sgpa.repository.MembroRepository;

@DataJpaTest
@Rollback
class MembroRepositoryTest {

	@Autowired
	private MembroRepository repository;

	@BeforeEach
	void setUp() {
		Membro membro = new Membro("Enzo Henrique", "98765432100", "Masculino", LocalDate.of(2000, 2, 21), "8798175324",
				"9879811595", "enzoh@gmail.com", null, "MA1234567890", null, StatusDePagamento.EFETUADO, 21);
		repository.save(membro);
	}

	@Test
	void existsByNumeroDeMatriculaTest() {
		boolean exists = repository.existsByNumeroDeMatricula("MA1234567890");
		assertTrue(exists);
	}

	@Test
	void findByCpfOrderByNomeTest() {
		Optional<Membro> foundMembro = repository.findByCpfOrderByNome("98765432100");
		assertThat(foundMembro).isPresent();
		assertThat(foundMembro.get().getNome()).isEqualTo("Enzo Henrique");
	}

	@Test
	void findByNumeroDeMatriculaOrderByNomeTest() {
		Optional<Membro> foundMembro = repository.findByNumeroDeMatriculaOrderByNome("MA1234567890");
		assertThat(foundMembro).isPresent();
		assertThat(foundMembro.get().getNome()).isEqualTo("Enzo Henrique");
	}

	@Test
	void findByNomeContainingIgnoreCaseOrderByNomeTest() {
		// Adicionando membros adicionais para o teste de nome
		Membro membro1 = new Membro("Ana Silva", "12345678910", "Feminino", LocalDate.of(1995, 3, 15), "8798165324",
				"9879811590", "ana.silva@gmail.com", null, "MA1234567891", null, StatusDePagamento.EFETUADO, 29);
		Membro membro2 = new Membro("André Santos", "12345678911", "Masculino", LocalDate.of(1993, 7, 10), "8798165325",
				"9879811591", "andre.santos@gmail.com", null, "MA1234567892", null, StatusDePagamento.EFETUADO, 31);
		repository.save(membro1);
		repository.save(membro2);

		// Busca por nomes que contenham "an" ignorando maiúsculas/minúsculas
		List<Membro> foundMembros = repository.findByNomeContainingIgnoreCaseOrderByNome("an");
		assertThat(foundMembros).hasSize(2);
	}

	@Test
	void findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNomeTest() {
		// Adicionando um membro adicional para o teste de múltiplos critérios de busca
		Membro membro3 = new Membro("Carlos", "55566677788", "Masculino", LocalDate.of(1988, 5, 20), "8798165326",
				"9879811592", "carlos@gmail.com", null, "MA1234567893", null, StatusDePagamento.EFETUADO, 36);
		repository.save(membro3);

		// Busca pelo CPF
		List<Membro> foundByCpf = repository
				.findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNome("55566677788", null, null);
		assertThat(foundByCpf).hasSize(1);
		assertThat(foundByCpf.get(0).getNome()).isEqualTo("Carlos");

		// Busca pelo número de matrícula
		List<Membro> foundByMatricula = repository
				.findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNome(null, "MA1234567890", null);
		assertThat(foundByMatricula).hasSize(1);
		assertThat(foundByMatricula.get(0).getNome()).isEqualTo("Enzo Henrique");

		// Busca por parte do nome
		List<Membro> foundByName = repository.findByCpfOrNumeroDeMatriculaOrNomeContainingIgnoreCaseOrderByNome(null,
				null, "Enzo");
		assertThat(foundByName).hasSize(1);
		assertThat(foundByName.get(0).getNome()).isEqualTo("Enzo Henrique");
	}

	@Test
	void deleteByCpfTest() {
		repository.deleteByCpf("98765432100");

		Optional<Membro> deletedMembro = repository.findByCpfOrderByNome("98765432100");
		assertThat(deletedMembro).isEmpty();
	}

}
