package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Syllabus implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String module;
    private String level;
    private String overview;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "syllabus")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Exercice> exercices;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "syllabus")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Competence> competences;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "syllabus")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Description> descriptions;


    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "syllabus")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Partie> parties;

    public List<Exercice> getExercices() {
        return exercices;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Partie> getParties() {
        return parties;
    }

    public void setParties(List<Partie> parties) {
        this.parties = parties;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Syllabus() {
    }
}
