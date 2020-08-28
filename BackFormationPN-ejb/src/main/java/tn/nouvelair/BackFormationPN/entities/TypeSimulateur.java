package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class TypeSimulateur  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private String typeSimulateur;


    @Column(unique=true)
    private String CodeTypeSimulateur;

    public TypeSimulateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeSimulateur() {
        return typeSimulateur;
    }

    public void setTypeSimulateur(String typeSimulateur) {
        this.typeSimulateur = typeSimulateur;
    }

    public String getCodeTypeSimulateur() {
        return CodeTypeSimulateur;
    }

    public void setCodeTypeSimulateur(String codeTypeSimulateur) {
        CodeTypeSimulateur = codeTypeSimulateur;
    }
}
