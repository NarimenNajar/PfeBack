package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("2")

public class Seance extends Activite implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )

    private int id;
    @ManyToOne
    private FormationPN formationPN;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "seance")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public FormationPN getFormationPN() {
        return formationPN;
    }

    public void setFormationPN(FormationPN formationPN) {
        this.formationPN = formationPN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seance() {
    }
}
