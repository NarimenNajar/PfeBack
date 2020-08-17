package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Simulateur extends ActiviteFormation implements Serializable{


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )
    private int id;
    private String commentaire;
    private String resultFinal;
    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "simulateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Level> levels;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "simulateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Note> notes;

    @ManyToOne
    private Syllabus syllabus;

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getResultFinal() {
        return resultFinal;
    }

    public void setResultFinal(String resultFinal) {
        this.resultFinal = resultFinal;
    }

    public Simulateur() {
    }

}
