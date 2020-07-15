package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Reclamation implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String objet;
    private Date date;
    private String contenu;
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Reclamation() {
    }
}
