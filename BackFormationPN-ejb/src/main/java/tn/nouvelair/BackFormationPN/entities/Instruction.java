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
    private InstructionPK id= new InstructionPK();
    private int valide;
    private Date dateEch;
    private Date dateDebutToler;
    private Date dateFinToler;
    private String position;
    private boolean echeance;


    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @MapsId("idUtilisateur")
    @JoinColumn(name ="idUtilisateur",referencedColumnName ="id",insertable = true,updatable = true)
    private Utilisateur utilisateur;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @MapsId("idActiviteFormation")
    @JoinColumn(name = "idActiviteFormation",referencedColumnName = "id",insertable = true,updatable = true)
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
        return dateEch;
    }

    public void setDateEch(Date dateEch) {
        this.dateEch = dateEch;
    }

    public Date getDateDebutToler() {
        return dateDebutToler;
    }

    public void setDateDebutToler(Date dateDebutToler) {
        this.dateDebutToler = dateDebutToler;
    }

    public Date getDateFinToler() {
        return dateFinToler;
    }

    public void setDateFinToler(Date dateFinToler) {
        this.dateFinToler = dateFinToler;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isEcheance() {
        return echeance;
    }

    public void setEcheance(boolean echeance) {
        this.echeance = echeance;
    }

}
