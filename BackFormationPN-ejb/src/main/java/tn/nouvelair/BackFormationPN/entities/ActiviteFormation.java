package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Inheritance(strategy= InheritanceType.SINGLE_TABLE)

@Entity
public class ActiviteFormation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )


    private int id;

    @Column(unique=true)
    private String CodeActivitéFormation;

    private int typeActivite;
    private int nombreJours;
    private Date dateDebutActivite;
    private Date dateFinActivite;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private NatureFormation natureFormation;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private Population population;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private TypeFormation typeFormation;

 /*   @ManyToMany( fetch=FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "EcheanceActivitePN",
            joinColumns = @JoinColumn(name = "activite_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private List<Utilisateur> utilisateurs;

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
*/

    @OneToMany(mappedBy = "activiteFormation")
    private List<Instruction> instructions;

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public ActiviteFormation() {
    }

    public String getCodeActivitéFormation() {
        return CodeActivitéFormation;
    }

    public void setCodeActivitéFormation(String codeActivitéFormation) {
        CodeActivitéFormation = codeActivitéFormation;
    }

    public int getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(int nombreJours) {
        this.nombreJours = nombreJours;
    }

    public Date getDateDebutActivite() {
        return dateDebutActivite;
    }

    public void setDateDebutActivite(Date dateDebutActivite) {
        this.dateDebutActivite = dateDebutActivite;
    }

    public Date getDateFinActivite() {
        return dateFinActivite;
    }

    public void setDateFinActivite(Date dateFinActivite) {
        this.dateFinActivite = dateFinActivite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(int typeActivite) {
        this.typeActivite = typeActivite;
    }



    public NatureFormation getNatureFormation() {
        return natureFormation;
    }

    public void setNatureFormation(NatureFormation natureFormation) {
        this.natureFormation = natureFormation;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public TypeFormation getTypeFormation() {
        return typeFormation;
    }

    public void setTypeFormation(TypeFormation typeFormation) {
        this.typeFormation = typeFormation;
    }
}
