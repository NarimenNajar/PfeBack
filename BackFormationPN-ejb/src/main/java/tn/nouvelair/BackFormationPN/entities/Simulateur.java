package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Simulateur extends ActiviteFormation implements Serializable{


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )
    private int id;
    private int Periode;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "simulateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<SeanceSimulateur> seanceSimulateurs;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Simulateur() {
    }



    public int getPeriode() {
        return Periode;
    }

    public void setPeriode(int periode) {
        Periode = periode;
    }

    public List<SeanceSimulateur> getSeanceSimulateurs() {
        return seanceSimulateurs;
    }

    public void setSeanceSimulateurs(List<SeanceSimulateur> seanceSimulateurs) {
        this.seanceSimulateurs = seanceSimulateurs;
    }
}
