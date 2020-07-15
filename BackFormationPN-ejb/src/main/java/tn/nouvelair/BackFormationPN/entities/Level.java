package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Level() {
    }
}
