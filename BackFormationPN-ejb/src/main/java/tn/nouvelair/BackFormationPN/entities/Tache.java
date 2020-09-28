package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties(allowSetters = true, value = {"partie","levels"})

@Entity
public class Tache implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String tache;

    @ManyToOne(fetch=FetchType.LAZY)
    private Partie partie;

    @OneToMany(mappedBy = "tache")
    private List<Level> levels;

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tache() {
    }
}
