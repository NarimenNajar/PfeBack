package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Role  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String role;

    @Column(unique=true)
    private String CodeRole;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Fonctionnalite> fonctionnalites;

    public List<Fonctionnalite> getFonctionnalites() {
        return fonctionnalites;
    }

    public void setFonctionnalites(List<Fonctionnalite> fonctionnalites) {
        this.fonctionnalites = fonctionnalites;
    }

    public String getCodeRole() {
        return CodeRole;
    }

    public void setCodeRole(String codeRole) {
        CodeRole = codeRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {
    }
}
