package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("1")

public class Simulateur extends ActiviteFormation implements Serializable{


    private int periode;

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "simulateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<SeanceSimulateur> seanceSimulateurs;





    public Simulateur() {
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public List<SeanceSimulateur> getSeanceSimulateurs() {
        return seanceSimulateurs;
    }

    public void setSeanceSimulateurs(List<SeanceSimulateur> seanceSimulateurs) {
        this.seanceSimulateurs = seanceSimulateurs;
    }
}
