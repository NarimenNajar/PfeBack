package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Inheritance(strategy= InheritanceType.SINGLE_TABLE)

@Entity
public class Activite implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )

    private int id;
    private int typeActivite;
    private int echeance;
    private Date dateActivite;


 /*   @ManyToMany( fetch=FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "EcheanceActivitePN",
            joinColumns = @JoinColumn(name = "activite_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private List<Utilisateur> utilisateurs;

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
*/
    public Activite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(int typeActivite) {
        this.typeActivite = typeActivite;
    }

    public int getEcheance() {
        return echeance;
    }

    public void setEcheance(int echeance) {
        this.echeance = echeance;
    }

    public Date getDateActivite() {
        return dateActivite;
    }

    public void setDateActivite(Date dateActivite) {
        this.dateActivite = dateActivite;
    }
}
