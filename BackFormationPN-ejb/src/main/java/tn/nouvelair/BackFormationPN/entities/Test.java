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

    @Column(unique=true)
    private String CodeTest;

    @ManyToOne
    private SeanceFormation seanceFormation;

    public SeanceFormation getSeanceFormation() {
        return seanceFormation;
    }

    public void setSeanceFormation(SeanceFormation seanceFormation) {
        this.seanceFormation = seanceFormation;
    }

    public String getCodeTest() {
        return CodeTest;
    }

    public void setCodeTest(String codeTest) {
        CodeTest = codeTest;
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
