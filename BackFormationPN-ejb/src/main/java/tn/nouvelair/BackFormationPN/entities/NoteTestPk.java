package tn.nouvelair.BackFormationPN.entities;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class NoteTestPk  implements Serializable {
    private int idUtilisateur;
    private int idTest;

    public NoteTestPk() {
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
}
