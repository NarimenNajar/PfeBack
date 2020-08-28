package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private Double note;
    @ManyToOne
    private SeanceSimulateur seanceSimulateur;

    public SeanceSimulateur getSeanceSimulateur() {
        return seanceSimulateur;
    }

    public void setSeanceSimulateur(SeanceSimulateur seanceSimulateur) {
        this.seanceSimulateur = seanceSimulateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
