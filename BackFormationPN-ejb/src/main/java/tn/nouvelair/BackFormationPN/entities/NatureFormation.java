package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class NatureFormation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private String natureFormation;

    public NatureFormation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNatureFormation() {
        return natureFormation;
    }

    public void setNatureFormation(String natureFormation) {
        this.natureFormation = natureFormation;
    }
}
