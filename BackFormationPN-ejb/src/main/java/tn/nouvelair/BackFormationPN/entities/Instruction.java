package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class Instruction implements Serializable{

    @EmbeddedId
    private InstructionPK id;
    private int valide;
    private Date DateEch;
    private Date DateDebutToler;
    private Date DateFinToler;
    private String Position;
    private boolean echeance;


    @ManyToOne
    @MapsId("idUtilisateur")
    @JoinColumn(name ="idUtilisateur",referencedColumnName ="id",insertable = false,updatable = false)
    private Utilisateur utilisateur;


    @ManyToOne
    @MapsId("idActiviteFormation")
    @JoinColumn(name = "idActForm",referencedColumnName = "id",insertable = false,updatable = false)
    private ActiviteFormation activiteFormation;

    public Instruction() {
    }

    public InstructionPK getId() {
        return id;
    }

    public void setId(InstructionPK id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ActiviteFormation getActiviteFormation() {
        return activiteFormation;
    }

    public void setActiviteFormation(ActiviteFormation activiteFormation) {
        this.activiteFormation = activiteFormation;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public Date getDateEch() {
        return DateEch;
    }

    public void setDateEch(Date dateEch) {
        DateEch = dateEch;
    }

    public Date getDateDebutToler() {
        return DateDebutToler;
    }

    public void setDateDebutToler(Date dateDebutToler) {
        DateDebutToler = dateDebutToler;
    }

    public Date getDateFinToler() {
        return DateFinToler;
    }

    public void setDateFinToler(Date dateFinToler) {
        DateFinToler = dateFinToler;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public boolean isEcheance() {
        return echeance;
    }

    public void setEcheance(boolean echeance) {
        this.echeance = echeance;
    }
}
