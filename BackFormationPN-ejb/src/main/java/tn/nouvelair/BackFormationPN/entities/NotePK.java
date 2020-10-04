package tn.nouvelair.BackFormationPN.entities;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NotePK implements Serializable {
    private int idCompetence;
    private int idSeanceSimulateur;

    public NotePK() {
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public int getIdSeanceSimulateur() {
        return idSeanceSimulateur;
    }

    public void setIdSeanceSimulateur(int idSeanceSimulateur) {
        this.idSeanceSimulateur = idSeanceSimulateur;
    }
}
