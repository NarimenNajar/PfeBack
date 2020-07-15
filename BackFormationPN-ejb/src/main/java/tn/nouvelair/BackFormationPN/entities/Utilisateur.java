package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Email> emails;

    @ManyToMany  ( mappedBy = "utilisateurs")
    private List<Activite> activites;


    public List<Activite> getActivites() {
        return activites;
    }

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)
    private Role role;

    @ManyToOne(cascade=CascadeType.MERGE , fetch=FetchType.EAGER)
    private Categorie categorie;


    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)

    private List<NumTel> numtels;

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<NumTel> getNumtels() {
        return numtels;
    }

    public void setNumtels(List<NumTel> numtels) {
        this.numtels = numtels;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public Utilisateur() {
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

    public Utilisateur(String codePN, String numLicencePN, String nom, String prenom, int rank, int cin, Date dateNaissance, Date dateDebutContrat, Date dateFinContrat, String nationalite, int typePN, String sexe, List<Activite> activites, Role role, Categorie categorie, List<Email> emails, List<NumTel> numtels) {
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
        this.activites = activites;
        this.role = role;
        this.categorie = categorie;

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
}
