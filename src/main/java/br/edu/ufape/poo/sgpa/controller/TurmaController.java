package br.edu.ufape.poo.sgpa.controller;

import br.edu.ufape.poo.sgpa.controller.dto.request.TurmaRequest;
import br.edu.ufape.poo.sgpa.controller.dto.response.TurmaResponse;
import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.TurmaComMembrosException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.facade.Facade;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/turmas")
public class TurmaController {

    @Autowired
    private Facade facade; // Supondo que o Facade agora lida com operações de Turma

    @GetMapping
    public List<TurmaResponse> listarTurmas() {
        return facade.listarTurmas()
                .stream()
                .map(TurmaResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaResponse cadastrarTurma(@RequestBody TurmaRequest novaTurma) throws CampoObrigatorioNuloException {
        return new TurmaResponse(facade.cadastrarTurma(novaTurma.toTurma()));
    }

    @GetMapping("/{id}")
    public TurmaResponse buscarTurmaPorId(@PathVariable Long id) throws TurmaNaoExisteException {
        return new TurmaResponse(facade.buscarTurmaPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTurma(@PathVariable Long id) throws TurmaNaoExisteException, TurmaComMembrosException {
        facade.deletarTurma(id);
    }

    @PutMapping("/{id}")
    public TurmaResponse atualizarTurma(@RequestBody TurmaRequest turmaAtualizada, @PathVariable Long id) throws TurmaNaoExisteException, CampoObrigatorioNuloException {
        return new TurmaResponse(facade.atualizarTurma(turmaAtualizada.toTurma(), id));
    }

    @GetMapping("/modalidade/{modalidade}")
    public List<TurmaResponse> buscarTurmasPorModalidade(@PathVariable String modalidade) {
        // Supondo que Modalidade seja um enum, é necessário convertê-lo a partir da string recebida
        return facade.buscarTurmasPorModalidade(Modalidade.valueOf(modalidade.toUpperCase()))
                .stream()
                .map(TurmaResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/instrutor/{instrutorId}")
    public List<TurmaResponse> buscarTurmasPorInstrutor(@PathVariable Long instrutorId) {
        return facade.buscarTurmasPorInstrutorId(instrutorId)
                .stream()
                .map(TurmaResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtrar")
    public List<TurmaResponse> buscarTurmasPorModalidadeOuInstrutor(
            @RequestParam(required = false) String modalidade,
            @RequestParam(required = false) Long instrutorId) {
        Modalidade mod = modalidade != null ? Modalidade.valueOf(modalidade.toUpperCase()) : null;
        return facade.buscarTurmasPorModalidadeOuInstrutor(mod, instrutorId)
                .stream()
                .map(TurmaResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Void> verificarExistenciaTurma(@PathVariable Long id) {
        boolean existe = facade.verificarExistenciaTurmaId(id);
        if (existe) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
