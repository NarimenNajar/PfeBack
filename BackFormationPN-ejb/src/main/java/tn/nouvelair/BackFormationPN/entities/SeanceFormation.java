package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;


@Entity
public class SeanceFormation  implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private int id;
    private Date dateSeanceFormation;

    @Column(unique=true)
    private String CodeSeanceFormation;

    @ManyToOne
    private Formation formation;

    public SeanceFormation() {
    }

    public String getCodeSeanceFormation() {
        return CodeSeanceFormation;
    }

    public void setCodeSeanceFormation(String codeSeanceFormation) {
        CodeSeanceFormation = codeSeanceFormation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateSeanceFormation() {
        return dateSeanceFormation;
    }

    public void setDateSeanceFormation(Date dateSeanceFormation) {
        this.dateSeanceFormation = dateSeanceFormation;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
