package br.edu.ufape.poo.sgpa.model;
import java.time.LocalTime;

import br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class SlotHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    public SlotHorario() {
    }

    public SlotHorario(LocalTime horarioInicial, LocalTime horarioFinal, br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana diaDaSemana) {
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.diaDaSemana = diaDaSemana;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    @Override
    public String toString() {
        return "SlotHorario{" +
                "id=" + id +
                ", horarioInicial=" + horarioInicial +
                ", horarioFinal=" + horarioFinal +
                ", DiaDaSemana=" + diaDaSemana +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SlotHorario that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getHorarioInicial(), that.getHorarioInicial()) && Objects.equals(getHorarioFinal(), that.getHorarioFinal()) && getDiaDaSemana() == that.getDiaDaSemana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHorarioInicial(), getHorarioFinal(), getDiaDaSemana());
    }
}
