package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EcheanceActivitePN implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private int id;
    private Date dateEch;
    private int valide;
    private Date dateDebutTolerance;
    private Date dateFinTolerance;
    private String test;


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDateEch() {
        return dateEch;
    }

    public void setDateEch(Date dateEch) {
        this.dateEch = dateEch;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public Date getDateDebutTolerance() {
        return dateDebutTolerance;
    }

    public void setDateDebutTolerance(Date dateDebutTolerance) {
        this.dateDebutTolerance = dateDebutTolerance;
    }

    public Date getDateFinTolerance() {
        return dateFinTolerance;
    }

    public void setDateFinTolerance(Date dateFinTolerance) {
        this.dateFinTolerance = dateFinTolerance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EcheanceActivitePN() {
    }
}
