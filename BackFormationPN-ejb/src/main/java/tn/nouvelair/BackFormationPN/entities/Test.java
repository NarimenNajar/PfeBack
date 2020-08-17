package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Test implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private  Date dateTest;
    @ManyToOne
    private SeanceFormation seanceFormation;

    public SeanceFormation getSeanceFormation() {
        return seanceFormation;
    }

    public void setSeanceFormation(SeanceFormation seanceFormation) {
        this.seanceFormation = seanceFormation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public Test() {
    }
}
