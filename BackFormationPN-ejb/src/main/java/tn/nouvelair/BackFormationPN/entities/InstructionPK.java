package tn.nouvelair.BackFormationPN.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class InstructionPK implements Serializable {
    private int idUtilisateur;
    private int idActiviteFormation;

    public InstructionPK() {
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdActiviteFormation() {
        return idActiviteFormation;
    }

    public void setIdActiviteFormation(int idActiviteFormation) {
        this.idActiviteFormation = idActiviteFormation;
    }
}
