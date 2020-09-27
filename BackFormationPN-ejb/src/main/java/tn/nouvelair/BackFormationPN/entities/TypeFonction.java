package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class TypeFonction implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String typeFonction;

    @Column(unique=true)
    private String codeTypeFonction;

    public TypeFonction() {
    }

    public String getCodeTypeFonction() {
        return codeTypeFonction;
    }

    public void setCodeTypeFonction(String codeTypeFonction) {
        this.codeTypeFonction = codeTypeFonction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeFonction() {
        return typeFonction;
    }

    public void setTypeFonction(String typeFonction) {
        this.typeFonction = typeFonction;
    }
}
