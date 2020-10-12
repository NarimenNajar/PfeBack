package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.Interfaces.UtilisateurServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Fonction;
import tn.nouvelair.BackFormationPN.entities.Instruction;
import tn.nouvelair.BackFormationPN.entities.Syllabus;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class UtilisateurService implements UtilisateurServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterUtilisateur(Utilisateur utilisateur) {
        em.persist(utilisateur);
    }

    @Override
    public Utilisateur getUserByEmailAndPassword(String codePN, int cin) {
        TypedQuery<Utilisateur> query = em.createQuery("Select p from Utilisateur p  "
                        +"where p.codePN=:codePN and "
                        +"p.cin=:cin"
                , Utilisateur.class);

        query.setParameter("codePN",codePN);
        query.setParameter("cin",cin);

        Utilisateur user = null ;

        try {
            user = query.getSingleResult();
        } catch (NoResultException p ) {
            Logger.getAnonymousLogger().info("Aucun utilisateur trouvé avec login :" + codePN);
        }
        return user;
    }

    @Override
    public List<Utilisateur> GetUsers() {
        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e "
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;


    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        em.merge(utilisateur);

    }

    @Override
    public List<Utilisateur> SelectUsersByCategorie(Integer idCategorie) {

        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e where e.categorie="+idCategorie
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;

    }

    @Override
    public List<Utilisateur> SelectUsersByRole(Integer idRole) {

        List<Utilisateur> users=null;
        TypedQuery<Utilisateur> query = em.createQuery("Select e from Utilisateur e where e.role="+idRole
                , Utilisateur.class);
        try {
            users = query.getResultList();
        } catch (NoResultException e ) {

        }
        return users;

    }

    @Override
    public void deleteUser(int idUser) {
        em.remove(em.find(Utilisateur.class, idUser));

    }

    @Override
    public Utilisateur getUtilisateurById(int idUtilisateur){
        return em.find(Utilisateur.class, idUtilisateur);

    }


    @Override
    public List<Instruction> SelectInstructionsByUser(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur
                , Instruction.class);
        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectInstructionsByInstructor(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Instructor'"
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectInstructionsByTrainee(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.position like 'Trainee'"
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public List<Instruction> SelectArchiveInstructions(Integer idUtilisateur) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.utilisateur="+idUtilisateur +"and e.activiteFormation.dateFinActivite < current_date "
                , Instruction.class);

        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }


    @Override
    public List<Fonction> SelectFonctionsByUser(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur
                , Fonction.class);
        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }

    @Override
    public List<Fonction> SelectArchiveFonctions(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur +"and e.dateFin < current_date "
                , Fonction.class);

        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }

    @Override
    public List<Fonction> SelectCurrentFonctions(Integer idUtilisateur) {

        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e where e.utilisateur="+idUtilisateur +"and e.dateFin >= current_date "
                , Fonction.class);

        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;

    }
}
