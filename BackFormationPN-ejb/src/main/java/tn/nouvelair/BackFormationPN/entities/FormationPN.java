package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class FormationPN implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String type;
    private Date date;
    private String Titre;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "formationPN")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Seance> seances;

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public FormationPN() {
    }
}
