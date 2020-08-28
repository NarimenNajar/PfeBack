package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String categorie;

    @Column(unique=true)
    private String CodeCategorie;

    public Categorie() {
    }

    public String getCodeCategorie() {
        return CodeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        CodeCategorie = codeCategorie;
    }

    public Categorie(String categorie) {
        this.categorie=categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
