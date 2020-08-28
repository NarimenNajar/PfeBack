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
    private String CodeFonctionnalité;

    public String getCodeFonctionnalité() {
        return CodeFonctionnalité;
    }

    public void setCodeFonctionnalité(String codeFonctionnalité) {
        CodeFonctionnalité = codeFonctionnalité;
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
