package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Level implements Serializable {

    @EmbeddedId
    private LevelPK id = new LevelPK();

    @JsonValue
    private String level;

    @ManyToOne
    @MapsId("idSeanceSimulateur")
    @JoinColumn(name ="idSeanceSimulateur",referencedColumnName ="id",insertable = true,updatable = true)
    private SeanceSimulateur seanceSimulateur;

    @ManyToOne
    @MapsId("idTache")
    @JoinColumn(name ="idTache",referencedColumnName ="id",insertable = true,updatable = true)
    private Tache tache;

    public SeanceSimulateur getSeanceSimulateur() {
        return seanceSimulateur;
    }

    public LevelPK getId() {
        return id;
    }

    public void setId(LevelPK id) {
        this.id = id;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public void setSeanceSimulateur(SeanceSimulateur seanceSimulateur) {
        this.seanceSimulateur = seanceSimulateur;
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
