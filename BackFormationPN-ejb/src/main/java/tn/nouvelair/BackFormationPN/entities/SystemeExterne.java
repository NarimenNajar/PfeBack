package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class SystemeExterne implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;

    @Column(unique=true)
    private String CodeSystemeExterne;

    private String serveur;
    private String motDePasse;
    private String user;
    private String token;
    private String sgbd;

    public SystemeExterne() {
    }

    public String getCodeSystemeExterne() {
        return CodeSystemeExterne;
    }

    public void setCodeSystemeExterne(String codeSystemeExterne) {
        CodeSystemeExterne = codeSystemeExterne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServeur() {
        return serveur;
    }

    public void setServeur(String serveur) {
        this.serveur = serveur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }
}
