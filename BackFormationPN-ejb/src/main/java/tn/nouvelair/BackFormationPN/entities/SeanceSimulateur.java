package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(allowSetters = true, value = {"simulateur","levels", "notes"})

@Entity
public class SeanceSimulateur implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private int id;

    @ManyToOne
    private Simulateur simulateur;

    @Column(unique=true)
    private String codeSeanceSimulateur;

    private Date dateSeanceSimulateur;

    private String commentaire;
    private String resultFinal;

    @OneToMany(mappedBy = "seanceSimulateur")
    private List<Level> levels;


    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "seanceSimulateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Note> notes;

    @ManyToOne
    private Syllabus syllabus;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private TypeSimulateur typeSimulateur;

    public SeanceSimulateur() {
    }


    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public String getCodeSeanceSimulateur() {
        return codeSeanceSimulateur;
    }

    public void setCodeSeanceSimulateur(String codeSeanceSimulateur) {
        this.codeSeanceSimulateur = codeSeanceSimulateur;
    }

    public Date getDateSeanceSimulateur() {
        return dateSeanceSimulateur;
    }

    public void setDateSeanceSimulateur(Date dateSeanceSimulateur) {
        this.dateSeanceSimulateur = dateSeanceSimulateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Simulateur getSimulateur() {
        return simulateur;
    }

    public void setSimulateur(Simulateur simulateur) {
        this.simulateur = simulateur;
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


    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public TypeSimulateur getTypeSimulateur() {
        return typeSimulateur;
    }

    public void setTypeSimulateur(TypeSimulateur typeSimulateur) {
        this.typeSimulateur = typeSimulateur;
    }
}
