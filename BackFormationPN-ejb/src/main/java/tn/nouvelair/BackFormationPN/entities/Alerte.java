package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class Alerte implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private Date dateAlerte;
    private int nbrJrsAvant;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private ParametrageEcheance parametrageEcheance;

    public Alerte() {
    }

    public ParametrageEcheance getParametrageEcheance() {
        return parametrageEcheance;
    }

    public void setParametrageEcheance(ParametrageEcheance parametrageEcheance) {
        this.parametrageEcheance = parametrageEcheance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAlerte() {
        return dateAlerte;
    }

    public void setDateAlerte(Date dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public int getNbrJrsAvant() {
        return nbrJrsAvant;
    }

    public void setNbrJrsAvant(int nbrJrsAvant) {
        this.nbrJrsAvant = nbrJrsAvant;
    }
}
