package br.edu.ufape.poo.sgpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "administrador", schema = "academia")
public class Administrador extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

}
