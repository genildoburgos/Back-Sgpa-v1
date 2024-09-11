package br.edu.ufape.poo.sgpa.repository;

import br.edu.ufape.poo.sgpa.model.Administrador; 
import org.springframework.data.jpa.repository.JpaRepository; 


public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    
 }