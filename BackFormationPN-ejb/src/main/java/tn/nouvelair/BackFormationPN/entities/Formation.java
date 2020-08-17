package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("2")

public class Formation extends ActiviteFormation implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "formation")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<SeanceFormation> seanceFormations;

  /*  @ManyToOne
    private FormationPN formationPN;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "seance")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Test> tests;
7
    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }*/

    public List<SeanceFormation> getSeanceFormations() {
        return seanceFormations;
    }

    public void setSeanceFormations(List<SeanceFormation> seanceFormations) {
        this.seanceFormations = seanceFormations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Formation() {
    }
}
