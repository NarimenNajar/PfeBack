package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Fonctionnalite implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String fonctionnalite;

    @Column(unique=true)
    private String codeFonctionnalite;

    public String getCodeFonctionnalite() {
        return codeFonctionnalite;
    }

    public void setCodeFonctionnalite(String codeFonctionnalite) {
        this.codeFonctionnalite = codeFonctionnalite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(String fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public Fonctionnalite() {
    }
}
