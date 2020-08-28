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

    @Column(unique=true)
    private String CodeNatureFormation;

    public NatureFormation() {
    }

    public String getCodeNatureFormation() {
        return CodeNatureFormation;
    }

    public void setCodeNatureFormation(String codeNatureFormation) {
        CodeNatureFormation = codeNatureFormation;
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
