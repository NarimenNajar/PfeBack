package tn.nouvelair.BackFormationPN.entities;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class LevelPK implements Serializable{
    private int idSeanceSimulateur;
    private int idTache;

    public LevelPK() {
    }

    public int getIdSeanceSimulateur() {
        return idSeanceSimulateur;
    }

    public void setIdSeanceSimulateur(int idSeanceSimulateur) {
        this.idSeanceSimulateur = idSeanceSimulateur;
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }
}
