package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class Population implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private String population;

    @Column(unique=true)
    private String codePopulation;

    public Population() {
    }

    public String getCodePopulation() {
        return codePopulation;
    }

    public void setCodePopulation(String codePopulation) {
        this.codePopulation = codePopulation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
