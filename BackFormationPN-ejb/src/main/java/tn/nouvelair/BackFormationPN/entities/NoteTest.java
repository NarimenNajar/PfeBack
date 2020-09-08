package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class NoteTest implements Serializable{
    @EmbeddedId
    private NoteTestPk id;
    private int note;


    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(name ="idUtilisateur",referencedColumnName ="id",insertable = false,updatable = false)
    private Utilisateur utilisateur;


    @ManyToOne
    @MapsId("idTest")
    @JoinColumn(name = "idTest",referencedColumnName = "id",insertable = false,updatable = false)
    private Test test;

    public NoteTest() {
    }

    public NoteTestPk getId() {
        return id;
    }

    public void setId(NoteTestPk id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
