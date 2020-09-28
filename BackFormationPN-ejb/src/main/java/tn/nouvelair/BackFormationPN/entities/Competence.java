package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;

@JsonIgnoreProperties(allowSetters = true, value = {"syllabus"})
@Entity
public class Competence implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String competence;

    @ManyToOne(fetch=FetchType.LAZY)
    private Syllabus syllabus;

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public Competence() {

    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
