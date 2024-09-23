package br.edu.ufape.poo.sgpa.api;

import br.edu.ufape.poo.sgpa.controller.InstrutorController;
import br.edu.ufape.poo.sgpa.controller.dto.request.InstrutorRequest;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.Instrutor;
import br.edu.ufape.poo.sgpa.service.InstrutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstrutorController.class)
@AutoConfigureMockMvc
public class InstrutorAPITest {
    //TODO: concertar problema de serialização do LocalDate
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstrutorService instrutorService;

    @MockBean
    private Facade facade; // Mock do Facade

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void criarInstrutorTest() throws Exception {
        InstrutorRequest instrutorRequest = new InstrutorRequest();
        instrutorRequest.setNome("Ravenna");
        instrutorRequest.setCpf("123456789");
        instrutorRequest.setSexo("Feminino");
        instrutorRequest.setDataDeNascimento(LocalDate.of(1998, 7, 22));
        instrutorRequest.setTelefone("(11) 98765-4321");
        instrutorRequest.setContatoDeEmergencia("Contato de Emergência");
        instrutorRequest.setEmail("ravenna@email.com");
        instrutorRequest.setIdade(25);
        instrutorRequest.setClt("123456");

        Instrutor instrutor = new Instrutor();
        instrutor.setNome("Ravenna");
        instrutor.setCpf("123456789");
        instrutor.setSexo("Feminino");
        instrutor.setDataDeNascimento(LocalDate.of(1998, 7, 22));
        instrutor.setTelefone("(11) 98765-4321");
        instrutor.setContatoDeEmergencia("Contato de Emergência");
        instrutor.setEmail("ravenna@email.com");
        instrutor.setIdade(25);
        instrutor.setClt("123456");

        when(instrutorService.criarInstrutor(any())).thenReturn(instrutor);

        mockMvc.perform(post("http://localhost:8080/api/v1/instrutor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instrutorRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Ravenna"))
                .andExpect(jsonPath("$.cpf").value("123456789"));
    }

    @Test
    public void listarInstrutoresTest() throws Exception {
        List<Instrutor> instrutores = Arrays.asList(
                new Instrutor(
                        "Ravenna",
                        "123456789",
                        "Feminino",
                        LocalDate.of(1998, 7, 22),
                        "(11) 98765-4321",
                        "Contato de Emergência",
                        "ravenna@email.com",
                        Collections.emptyList(), // Unidades
                        Collections.emptyList(), // Modalidades
                        Collections.emptyList(), // Horários de Trabalho
                        "123456",
                        25
                ),
                new Instrutor(
                        "John Doe",
                        "987654321",
                        "Masculino",
                        LocalDate.of(1990, 1, 1),
                        "(11) 12345-6789",
                        "Contato de Emergência",
                        "johndoe@email.com",
                        Collections.emptyList(), // Unidades
                        Collections.emptyList(), // Modalidades
                        Collections.emptyList(), // Horários de Trabalho
                        "654321",
                        34
                )
        );

        when(instrutorService.listarInstrutores()).thenReturn(instrutores);

        mockMvc.perform(get("http://localhost:8080/api/v1/instrutor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Ravenna"))
                .andExpect(jsonPath("$[1].nome").value("John Doe"));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        Instrutor instrutor = new Instrutor(
                "Ravenna",
                "123456789",
                "Feminino",
                LocalDate.of(1998, 7, 22),
                "(11) 98765-4321",
                "Contato de Emergência",
                "ravenna@email.com",
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                "123456",
                25
        );

        OngoingStubbing<Instrutor> instrutorOngoingStubbing = when(instrutorService.buscarInstrutor(1L)).thenReturn(instrutor);

        mockMvc.perform(get("http://localhost:8080/api/v1/instrutor/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Ravenna"));
    }

    @Test
    public void atualizarInstrutorTest() throws Exception {
        // Criação do InstrutorRequest
        InstrutorRequest instrutorRequest = new InstrutorRequest();
        instrutorRequest.setNome("Ravenna Atualizada");
        instrutorRequest.setCpf("123456789");
        instrutorRequest.setSexo("Feminino");
        instrutorRequest.setDataDeNascimento(LocalDate.of(1998, 7, 22));
        instrutorRequest.setTelefone("(11) 98765-4321");
        instrutorRequest.setContatoDeEmergencia("Contato de Emergência");
        instrutorRequest.setEmail("ravenna@email.com");
        instrutorRequest.setIdade(25);
        instrutorRequest.setClt("123456");

        // Criação do Instrutor atualizado
        Instrutor instrutorAtualizado = new Instrutor(
                "Ravenna Atualizada",
                "123456789",
                "Feminino",
                LocalDate.of(1998, 7, 22),
                "(11) 98765-4321",
                "Contato de Emergência",
                "ravenna@email.com",
                new ArrayList<>(), // Unidades
                new ArrayList<>(), // Modalidades
                new ArrayList<>(), // Horários de Trabalho
                "123456",
                25
        );

        // Mock do serviço
        when(instrutorService.atualizarInstrutor(any(Instrutor.class), eq(1L))).thenReturn(instrutorAtualizado);

        // Mock da conversão de InstrutorRequest para Instrutor
        Instrutor instrutorParaAtualizar = new Instrutor(
                instrutorRequest.getNome(),
                instrutorRequest.getCpf(),
                instrutorRequest.getSexo(),
                instrutorRequest.getDataDeNascimento(),
                instrutorRequest.getTelefone(),
                instrutorRequest.getContatoDeEmergencia(),
                instrutorRequest.getEmail(),
                new ArrayList<>(), // Unidades
                new ArrayList<>(), // Modalidades
                new ArrayList<>(), // Horários de Trabalho
                instrutorRequest.getClt(),
                instrutorRequest.getIdade()
        );

        mockMvc.perform(put("http://localhost:8080/api/v1/instrutor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instrutorRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Ravenna Atualizada"))
                .andExpect(jsonPath("$.cpf").value("123456789"));
    }



    @Test
    public void deletarInstrutorTest() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/api/v1/instrutor/1"))
                .andExpect(status().isNoContent());
    }
}
