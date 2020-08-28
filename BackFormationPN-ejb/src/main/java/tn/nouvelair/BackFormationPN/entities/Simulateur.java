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
    private String CodeSimulateur;
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

}
