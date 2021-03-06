package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;

@JsonIgnoreProperties(allowSetters = true, value = {"syllabus"})
@Entity
public class Exercice implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String exercice;

    @ManyToOne(fetch=FetchType.LAZY)
    private Syllabus syllabus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public Exercice() {
    }
}
