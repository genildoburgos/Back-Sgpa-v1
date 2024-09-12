package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Plano;
import br.edu.ufape.poo.sgpa.model.Unidade;
import br.edu.ufape.poo.sgpa.model.enums.Periodicidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
/*
    // Encontra planos pelo valor
    List<Plano> findByValor(double valor);

    // Encontra planos pela data de vencimento
    List<Plano> findByDataDeVencimento(String dataDeVencimento);

    // Encontra planos pela periodicidade
    List<Plano> findByPeriodicidade(Periodicidade periodicidade);

    // Encontra planos por unidade
    List<Plano> findByUnidade(Unidade unidade);

    // Encontra planos pelo valor e periodicidade
    List<Plano> findByValorAndPeriodicidade(double valor, Periodicidade periodicidade);
*/
}
