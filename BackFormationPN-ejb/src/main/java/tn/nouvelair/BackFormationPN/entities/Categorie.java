package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String categorie;

    public Categorie() {
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
