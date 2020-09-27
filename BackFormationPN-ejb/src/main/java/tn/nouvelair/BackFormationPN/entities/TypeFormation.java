package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class TypeFormation implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private String typeFormation;
    private String titreFormation;

    @Column(unique=true)
    private String codeTypeFormation;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)
    private ParametrageEcheance parametrageEcheance;

    public TypeFormation() {
    }

    public String getTitreFormation() {
        return titreFormation;
    }

    public void setTitreFormation(String titreFormation) {
        this.titreFormation = titreFormation;
    }

    public String getCodeTypeFormation() {
        return codeTypeFormation;
    }

    public void setCodeTypeFormation(String codeTypeFormation) {
        this.codeTypeFormation = codeTypeFormation;
    }

    public ParametrageEcheance getParametrageEcheance() {
        return parametrageEcheance;
    }

    public void setParametrageEcheance(ParametrageEcheance parametrageEcheance) {
        this.parametrageEcheance = parametrageEcheance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeFormation() {
        return typeFormation;
    }

    public void setTypeFormation(String typeFormation) {
        this.typeFormation = typeFormation;
    }
}
