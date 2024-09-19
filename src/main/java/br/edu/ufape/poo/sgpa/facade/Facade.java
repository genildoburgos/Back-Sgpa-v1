package br.edu.ufape.poo.sgpa.facade;

import br.edu.ufape.poo.sgpa.exception.CampoObrigatorioNuloException;
import br.edu.ufape.poo.sgpa.exception.CpfInvalidoException;
import br.edu.ufape.poo.sgpa.exception.DataForaDaFaixaException;
import br.edu.ufape.poo.sgpa.exception.MembroExisteException;
import br.edu.ufape.poo.sgpa.exception.MembroMenorDeIdadeException;
import br.edu.ufape.poo.sgpa.exception.MembroNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.SalaExisteException;
import br.edu.ufape.poo.sgpa.exception.SalaNaoExisteException;
import br.edu.ufape.poo.sgpa.exception.TelefoneInvalidoException;
import br.edu.ufape.poo.sgpa.exception.TurmaNaoExisteException;
import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import br.edu.ufape.poo.sgpa.service.*;
import br.edu.ufape.poo.sgpa.model.enums.Modalidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Facade {

	public Facade(MembroService membroService, PlanoService planoService, VagaService vagaService,
                  InstrutorService instrutorService, AdministradorService administradorService, UnidadeService unidadeService,
                  TurmaService turmaService, MatriculaService matriculaService, SalaService salaService) {
		this.membroService = membroService;
		this.planoService = planoService;
		this.vagaService = vagaService;
		this.instrutorService = instrutorService;
		this.administradorService = administradorService;
		this.unidadeService = unidadeService;
		this.turmaService = turmaService;
        this.matriculaService = matriculaService;
        this.salaService = salaService;
    }

	// ------------------------ Membro --------------------------------

	@Autowired
	private final MembroService membroService;

	// Atualizar membro
	public void atualizarMembro(Membro membroAtualizado, Long id) throws MembroNaoExisteException,
			CampoObrigatorioNuloException, TelefoneInvalidoException, DataForaDaFaixaException {
		membroService.atualizarMembro(membroAtualizado, id);
	}

	// Buscar membro por CPF
	public Optional<Membro> buscarMembroPorCpf(String cpf) throws MembroNaoExisteException {
		return membroService.buscarMembroPorCpf(cpf);
	}
	
	// Buscar membro por ID
	public Optional<Membro> buscarMembroPorId(Long id) throws MembroNaoExisteException {
		return membroService.buscarMembroPorId(id);
	}

	// Buscar membro por número de matrícula
	public Optional<Membro> buscarMembroPorNumeroDeMatricula(String numeroDeMatricula) throws MembroNaoExisteException {
		return membroService.buscarMembroPorNumeroDeMatricula(numeroDeMatricula);
	}

	// Buscar membro por nome
	public List<Membro> buscarMembroPorNome(String nome) {
		return membroService.buscarMembroPorNome(nome);
	}

	// Buscar membro por CPF, número de matrícula ou nome
	public List<Membro> buscarMembroPorCpfOuNumeroDeMatriculaOuNome(String cpf, String numeroDeMatricula, String nome) {
		return membroService.buscarMembroPorCpfOuNumeroDeMatriculaOuNome(cpf, numeroDeMatricula, nome);
	}

	// Cadastrar um novo membro
	public void cadastrarMembro(Membro novoMembro) throws CampoObrigatorioNuloException, CpfInvalidoException,
			MembroExisteException, TelefoneInvalidoException, DataForaDaFaixaException, MembroMenorDeIdadeException {
		membroService.cadastrarMembro(novoMembro);
	}

	// Deletar membro por CPF
	public void deletarMembroPorCpf(String cpf) throws MembroNaoExisteException {
		membroService.deletarMembroPorCpf(cpf);
	}

	// Listar todos os membros
	public List<Membro> listarMembros() {
		return membroService.listarMembros();
	}

	// ------------------------ Plano --------------------------------

	@Autowired
	private final PlanoService planoService;

	// Listar planos
	public List<Plano> listarPlanos() {
		return planoService.listarPlanos();
	}

	// Criar plano
	public Plano criarPlano(Plano obj) {
		return planoService.criarPlano(obj);
	}

	// Deletar plano
	public void deletarPlano(Long id) {
		planoService.deletarPlano(id);
	}

	// Buscar plano por id
	public Plano buscarPlano(Long id) {
		return planoService.buscarPlano(id);
	}

	// Atualizar plano
	public Plano atualizarPlano(Plano obj, Long id) {
		return planoService.atualizarPlano(obj, id);
	}

	// ------------------------ Vaga --------------------------------

	@Autowired
	private final VagaService vagaService;

	// Listar vagas
	public List<Vaga> listarVagas() {
		return vagaService.listarVagas();
	}

	// Criar nova vaga
	public Vaga criarVaga(Vaga novoObj) {
		return vagaService.criarVaga(novoObj);
	}

	// Deletar vaga
	public void deletarVaga(Long id) {
		vagaService.deletarVaga(id);
	}

	// Burcar vaga por Id
	public Vaga buscarVagaPorId(Long id) {
		return vagaService.buscarVagaPorId(id);
	}

	// Atulizar vaga
	public Vaga atualizarVaga(Vaga obj, Long id) {
		return vagaService.atualizarVaga(obj, id);
	}

	// ---------------------- Instrutor ---------------------------
	@Autowired
	private final InstrutorService instrutorService;

	// Listar instrutor
	public List<Instrutor> listarInstrutores() {
		return instrutorService.listarInstrutores();
	}

	// criar instrutor
	public Instrutor criarInstrutor(Instrutor novoInstrutor) {
		return instrutorService.criarInstrutor(novoInstrutor);
	}

	// deletar instrutor
	public void deletarInstrutor(Long id) {
		instrutorService.deletarIntrutor(id);
	}

	// buscar instrutor por id
	public Instrutor buscarInstrutor(Long id) {
		return instrutorService.buscarInstrutor(id);
	}

	// atualizar instrutor
	public Instrutor atualizarInstrutor(Instrutor instrutor, Long id) {
		return instrutorService.atualizarInsturor(instrutor, id);
	}

	//buscar por cpf
	public Instrutor buscarInstrutorPorCpf(String cpf) {
		return instrutorService.buscarInstrutorPorCpf(cpf);
	}

	//buscar por nome
	public List<Instrutor> buscarInstrutorPorNome(String nome){
		return instrutorService.buscarInstrutoresPorNome(nome);
	}

	// ------------------- Unidade --------------------
	@Autowired
	private final UnidadeService unidadeService;

	// listar unidades
	public List<Unidade> listarUnidades() {
		return unidadeService.listarUnidades();
	}

	// criar unidade
	public Unidade criarUnidade(Unidade unidade) {
		return unidadeService.criarUnidade(unidade);
	}

	// deletar unidade
	public void deletarUnidade(Long id) {
		unidadeService.deletarUnidade(id);
	}

	// buscar unidade por id
	public Unidade buscarUnidade(Long id) {
		return unidadeService.buscarUnidade(id);
	}

	// atualizar unidade
	public Unidade atualizarUnidade(Unidade unidade, Long id) {
		return unidadeService.atualizarUnidade(unidade, id);
	}

	//buscar unidade por nome
	 public List<Unidade> buscarUnidadesPorNome(String nome) {
        return unidadeService.buscarUnidadesPorNome(nome);
    }

	//buscar unidade por cnpj
    public Unidade buscarUnidadePorCnpj(String cnpj) {
        return unidadeService.buscarUnidadePorCnpj(cnpj);
    }

	// ------------------- Administrador --------------------

	@Autowired
	private final AdministradorService administradorService;

	public List<Administrador> listarAdministradores() {
		return administradorService.listarAdministradores();
	}

	public Administrador criarAdministrador(Administrador novaInstancia) {
		return administradorService.criarAdministrador(novaInstancia);
	}

	public void deletarAdministrador(Long id) {
		administradorService.deletarAdministrador(id);
	}

	public Administrador buscarAdministradorPorId(Long id) {
		return administradorService.buscarAdministradorPorId(id);
	}

	public Administrador atualizarAdministrador(Administrador administrador, Long id) {
		return administradorService.atualizarAdministrador(administrador, id);
	}

	public Administrador buscarAdministradorPorCpf(String cpf) {
		return administradorService.buscarAdministradorPorCpf(cpf);
	}

	public List<Administrador> buscarAdministradoresPorNome(String nome) {
		return administradorService.buscarAdministradoresPorNome(nome);
	}

	// ------------------- Turma --------------------

	@Autowired
	private final TurmaService turmaService;

	public Turma atualizarTurma(Turma turmaAtualizada, Long id) {
		return turmaService.atualizarTurma(turmaAtualizada, id);
	}

	public Turma buscarTurmaPorId(Long id) {
		return turmaService.buscarTurmaPorId(id);
	}

	public List<Turma> buscarTurmasPorModalidade(Modalidade modalidade) {
		return turmaService.buscarTurmasPorModalidade(modalidade);
	}

	public List<Turma> buscarTurmasPorInstrutorId(Long id) {
		Instrutor instrutor = buscarInstrutor(id);
		return turmaService.buscarTurmasPorInstrutor(instrutor);
	}

	public List<Turma> buscarTurmasPorModalidadeOuInstrutor(Modalidade modalidade, Long id) {
		Instrutor instrutor = buscarInstrutor(id);
		return turmaService.buscarTurmasPorModalidadeOuInstrutor(modalidade, instrutor);
	}

	public Turma cadastrarTurma(Turma entity) {
		Vaga vagaCompleta = vagaService.buscarVagaPorId(entity.getVaga().getId());
		entity.setVaga(vagaCompleta);
		return turmaService.cadastrarTurma(entity);
	}

	public void deletarTurma(Long id) throws TurmaNaoExisteException {
		turmaService.deletarTurma(id);
	}

	public List<Turma> listarTurmas() {
		return turmaService.listarTurmas();
	}

	public boolean verificarExistenciaTurmaId(Long id) {
		return turmaService.verificarExistenciaTurmaId(id);
	}

	//--------------- Matricula---------------------------
	@Autowired
	private final MatriculaService matriculaService;

	public Matricula criarMatricula(Matricula matricula) {
		return matriculaService.criarMatricula(matricula);
	}

	public List<Matricula> listarMatriculas() {
		return matriculaService.listarMatriculas();
	}

	public Matricula buscarMatriculaPorId(Long id) {
		return matriculaService.buscarMatricula(id);
	}

	public void deletarMatricula(Long id){
		matriculaService.deletarMatricula(id);
	}

	public Matricula atualizarMatricula(Matricula matricula, Long id){
		return matriculaService.atualizarMatricula(matricula, id);
	}

	public List<Matricula> buscarMatriculasPorMembro(Membro membro) {
		return matriculaService.buscarMatriculasPorMembro(membro);
	}

	public List<Matricula> buscarMatriculaPorDataExpiracao(LocalDate dataExpiracao) {
		return matriculaService.buscarPorDataExpiracao(dataExpiracao);
	}

	public List<Matricula> buscarMatriculaPorDataDeMatricula(LocalDate dataMatricula) {
		return matriculaService.buscarPorDataDeMatricula(dataMatricula);
	}

	public List<Matricula> buscarMatriculaPorStatus(StatusDaMatricula status) {
		return matriculaService.buscarPorStatus(status);
	}

	public void ativarMatricula(Matricula matricula) {
		matriculaService.ativarMatricula(matricula);
	}

	public void suspenderMatricula(Matricula matricula) {
		matriculaService.suspenderMatricula(matricula);
	}

	public boolean matriculaEstaExpirada(Matricula matricula) {
		return matriculaService.estaExpirada( matricula );
	}
	
	//--------------- Matricula---------------------------
	@Autowired
	private final SalaService salaService;

	public Optional<Sala> buscarSalaPorBlocoENumero(String bloco, String numero) {
		return salaService.buscarSalaPorBlocoENumero(bloco, numero);
	}

	public Sala criarSala(Sala sala) throws CampoObrigatorioNuloException, SalaExisteException {
		return salaService.criarSala(sala);
	}

	public Optional<Sala> buscarSalaPorId(Long id) throws SalaNaoExisteException {
		return salaService.buscarSalaPorId(id);
	}

	public void deletarSalaPorId(Long id) throws SalaNaoExisteException {
		salaService.deletarSalaPorId(id);
	}

	public void deletarSala(Sala entity) throws SalaNaoExisteException {
		salaService.deletarSala(entity);
	}
	
}
