package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Test implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private  Date dateTest;
    @ManyToOne
    private Seance seance;

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
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
