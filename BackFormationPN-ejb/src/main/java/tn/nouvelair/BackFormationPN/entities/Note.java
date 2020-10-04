package tn.nouvelair.BackFormationPN.entities;
import sun.plugin.com.event.COMEventHandler;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Note implements Serializable {

    @EmbeddedId
    private NotePK id;

    private Double note;

    @ManyToOne
    @MapsId("idSeanceSimulateur")
    @JoinColumn(name ="idSeanceSimulateur",referencedColumnName ="id",insertable = false,updatable = false)
    private SeanceSimulateur seanceSimulateur;

    @ManyToOne
    @MapsId("idCompetence")
    @JoinColumn(name ="idCompetence",referencedColumnName ="id",insertable = false,updatable = false)
    private Competence competence;


    public NotePK getId() {
        return id;
    }

    public void setId(NotePK id) {
        this.id = id;
    }

    public SeanceSimulateur getSeanceSimulateur() {
        return seanceSimulateur;
    }

    public void setSeanceSimulateur(SeanceSimulateur seanceSimulateur) {
        this.seanceSimulateur = seanceSimulateur;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Note() {
    }
}
