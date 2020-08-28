package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class TypeAlerte implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String typeAlerte;

    @Column(unique=true)
    private String CodeTypeAlerte;

    public TypeAlerte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeAlerte() {
        return typeAlerte;
    }

    public void setTypeAlerte(String typeAlerte) {
        this.typeAlerte = typeAlerte;
    }

    public String getCodeTypeAlerte() {
        return CodeTypeAlerte;
    }

    public void setCodeTypeAlerte(String codeTypeAlerte) {
        CodeTypeAlerte = codeTypeAlerte;
    }
}
