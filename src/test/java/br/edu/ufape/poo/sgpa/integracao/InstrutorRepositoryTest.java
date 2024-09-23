package br.edu.ufape.poo.sgpa.integracao;

import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.repository.InstrutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback // Desfaz as alterações no banco de dados após o teste
public class InstrutorRepositoryTest {

    @Autowired
    private InstrutorRepository instrutorRepository;

    private Instrutor instrutor;

    @BeforeEach
    public void setUp() {
        instrutor = new Instrutor("Ravenna", "123456789", "Feminino", LocalDate.of(1998, 7, 22),
                "(11) 98765-4321", "(11) 91234-5678", "ravenna@example.com", null, null, null, "123456789", 26);
        instrutorRepository.save(instrutor);
    }

    @Test
    public void buscarInstrutorPorIdTest() {
        Optional<Instrutor> found = instrutorRepository.findById(instrutor.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getNome()).isEqualTo("Ravenna");
    }

    @Test
    public void buscarInstrutorPorCpfTest() {
        Optional<Instrutor> found = instrutorRepository.findByCpf("123456789");
        assertThat(found).isPresent();
        assertThat(found.get().getNome()).isEqualTo("Ravenna");
    }

    @Test
    public void deletarInstrutorPorIdTest() {
        Long id = instrutor.getId();
        instrutorRepository.deleteById(id);
        Optional<Instrutor> found = instrutorRepository.findById(id);
        assertThat(found).isNotPresent();
    }

    @Test
    public void atualizarInstrutorTest() {
        instrutor.setNome("Ravenna Silva");
        instrutorRepository.save(instrutor);

        Optional<Instrutor> updated = instrutorRepository.findById(instrutor.getId());
        assertThat(updated).isPresent();
        assertThat(updated.get().getNome()).isEqualTo("Ravenna Silva");
    }

    @Test
    public void listarInstrutoresTest() {
        Iterable<Instrutor> instrutores = instrutorRepository.findAll();
        assertThat(instrutores).isNotEmpty();
        assertThat(instrutores).contains(instrutor);
    }
}
