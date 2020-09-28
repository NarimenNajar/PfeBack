package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.*;

@JsonIgnoreProperties(allowSetters = true, value = {"syllabus"})
@Entity
public class Partie implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String partie;

    @ManyToOne(fetch=FetchType.LAZY)
    private Syllabus syllabus;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "partie")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Tache> taches;

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public String getPartie() {
        return partie;
    }

    public void setPartie(String partie) {
        this.partie = partie;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partie() {
    }
}
