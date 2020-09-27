package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.util.*;
import java.util.ArrayList;

@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    @Column(unique=true)
    private String codePN ;

    private String numLicencePN ;
    private String nom ;
    private String prenom ;
    private int rank;
    private int cin;
    private Date dateNaissance ;
    private Date dateDebutContrat ;
    private Date dateFinContrat ;
    private String nationalite ;
    private int typePN;
    private String sexe;


    private String numeroTel;

    private String email;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "utilisateur")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Fonction> fonctions;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private Role role;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)

    private Categorie categorie;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "utilisateur")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Instruction> instructions;


    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "utilisateur")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<NoteTest> noteTests;

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Utilisateur() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<NoteTest> getNoteTests() {
        return noteTests;
    }

    public void setNoteTests(List<NoteTest> noteTests) {
        this.noteTests = noteTests;
    }

    public Utilisateur(String codePN, String numLicencePN, String nom, String prenom, int rank, int cin, Date dateNaissance, Date dateDebutContrat, Date dateFinContrat, String nationalite, int typePN, String sexe, List<ActiviteFormation> activites, Role role, Categorie categorie) {
        this.codePN = codePN;
        this.numLicencePN = numLicencePN;
        this.nom = nom;
        this.prenom = prenom;
        this.rank = rank;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.nationalite = nationalite;
        this.typePN = typePN;
        this.sexe = sexe;
        this.role = role;
        this.categorie = categorie;

    }

    public Utilisateur(String codePN, String numLicencePN, String nom, String prenom, int rank, int cin, Date dateNaissance, Date dateDebutContrat, Date dateFinContrat, String nationalite, int typePN, String sexe) {
        this.codePN = codePN;
        this.numLicencePN = numLicencePN;
        this.nom = nom;
        this.prenom = prenom;
        this.rank = rank;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.nationalite = nationalite;
        this.typePN = typePN;
        this.sexe = sexe;


    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePN() {
        return codePN;
    }

    public void setCodePN(String codePN) {
        this.codePN = codePN;
    }

    public String getNumLicencePN() {
        return numLicencePN;
    }

    public void setNumLicencePN(String numLicencePN) {
        this.numLicencePN = numLicencePN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getTypePN() {
        return typePN;
    }

    public void setTypePN(int typePN) {
        this.typePN = typePN;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return id == that.id &&
                rank == that.rank &&
                cin == that.cin &&
                typePN == that.typePN &&
                Objects.equals(codePN, that.codePN) &&
                Objects.equals(numLicencePN, that.numLicencePN) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(dateDebutContrat, that.dateDebutContrat) &&
                Objects.equals(dateFinContrat, that.dateFinContrat) &&
                Objects.equals(nationalite, that.nationalite) &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(role, that.role) &&
                Objects.equals(categorie, that.categorie) ;
    }


}
