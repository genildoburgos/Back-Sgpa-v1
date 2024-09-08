package br.edu.ufape.poo.sgpa.model;
import java.time.LocalTime;

import br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="slotHorario", schema="academia")
public class SlotHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="horarioinicial")
    private LocalTime horarioInicial;
    @Column(name="horariofinal")
    private LocalTime horarioFinal;
    @Enumerated(EnumType.STRING)
    @Column(name = "diadasemana")
    private DiaDaSemana DiaDaSemana;

    public SlotHorario() {
    }

    public SlotHorario(LocalTime horarioInicial, LocalTime horarioFinal, br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana diaDaSemana) {
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        DiaDaSemana = diaDaSemana;
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
        return DiaDaSemana;
    }

    public void setDiaDaSemana(br.edu.ufape.poo.sgpa.model.enums.DiaDaSemana diaDaSemana) {
        DiaDaSemana = diaDaSemana;
    }

    @Override
    public String toString() {
        return "SlotHorario{" +
                "id=" + id +
                ", horarioInicial=" + horarioInicial +
                ", horarioFinal=" + horarioFinal +
                ", DiaDaSemana=" + DiaDaSemana +
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
