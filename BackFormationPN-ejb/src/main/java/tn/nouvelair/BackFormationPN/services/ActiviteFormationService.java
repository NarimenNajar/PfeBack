package tn.nouvelair.BackFormationPN.services;


import tn.nouvelair.BackFormationPN.Interfaces.ActiviteFormationServiceRemote;
import tn.nouvelair.BackFormationPN.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;


@Stateless
@LocalBean
public class ActiviteFormationService  implements ActiviteFormationServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    /////// simulateur

    @Override
    public void AjouterSimulateur(Simulateur simulateur) {
        em.persist(simulateur);
        simulateur.getSeanceSimulateurs().forEach((seanceSimulateur) ->
        {   seanceSimulateur.setSimulateur(simulateur);
            em.persist(seanceSimulateur);
        });
        System.out.println("simulateur ");
    }

    @Override
    public List<Simulateur> GetSimulateurs() {
        List<Simulateur> simulateurs=null;
        TypedQuery<Simulateur> query = em.createQuery("Select e from Simulateur e "
                , Simulateur.class);
        try {
            simulateurs = query.getResultList();
        } catch (NoResultException e ) {

        }
        return simulateurs;
    }

    @Override
    public void UpdateSimulateur(Simulateur simulateur) {
        em.merge(simulateur);
    }

    @Override
    public void deleteSimulateur(int idSimulateur) {
        em.remove(em.find(Simulateur.class, idSimulateur));
    }

    @Override
    public Simulateur getSimulateurById(int idSimulateur){
        return em.find(Simulateur.class, idSimulateur);

    }

    //////   Formation



    @Override
    public void AjouterFormation(Formation formation) {
        int size = formation.getSeanceFormations().size();
        formation.setNombreJours(size);
        em.persist(formation);
        formation.getSeanceFormations().forEach((seanceFormation) ->
        {   seanceFormation.setFormation(formation);
            em.persist(seanceFormation);
        });
        System.out.println("formation ");
        formation.getInstructions().forEach((instruction) ->
        {  // instruction.getId().setIdActiviteFormation(formation.getId());
            // instruction.getId().setIdUtilisateur(instruction.getUtilisateur().getId());
            System.out.println(instruction.getUtilisateur().getId());
            Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            instruction.setUtilisateur(user);
            System.out.println(instruction.getUtilisateur().getId());
            instruction.setActiviteFormation(formation);

            System.out.println(instruction.getUtilisateur().getId());
            System.out.println(instruction.getActiviteFormation().getId());
            System.out.println(instruction.getPosition());
            System.out.println("avant perst");

            em.persist(instruction);
            System.out.println("aaaaa");
           // Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
          //  Utilisateur user=instruction.getUtilisateur();
            //System.out.println(user.getId());
          /*  Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            user.getInstructions().add(instruction);
            em.merge(user);
            //user.getInstructions().add(instruction);
            System.out.println("bbbb");

            //em.merge(user);*/
            System.out.println("cccc");

        });
        System.out.println("instruction ");

    }


    @Override
    public void AjouterFormationPNC(Formation formation) {
        int size = formation.getSeanceFormations().size();
        int n = 1 ;
        formation.setNombreJours(size);
        formation.setTypeActivite(n);
        System.out.println(formation.getTypeActivite());

        em.persist(formation);
        formation.getSeanceFormations().forEach((seanceFormation) ->
        {   seanceFormation.setFormation(formation);
            em.persist(seanceFormation);
        });
        System.out.println("formation ");
        formation.getInstructions().forEach((instruction) ->
        {
            System.out.println(instruction.getUtilisateur().getId());
            Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            instruction.setUtilisateur(user);
            System.out.println(instruction.getUtilisateur().getId());
            instruction.setActiviteFormation(formation);

            System.out.println(instruction.getUtilisateur().getId());
            System.out.println(instruction.getActiviteFormation().getId());
            System.out.println(instruction.getPosition());
            System.out.println("avant perst");

            em.persist(instruction);
            System.out.println("aaaaa");

            System.out.println("cccc");

        });
        System.out.println("instruction ");

    }


    @Override
    public void AjouterFormationPNT(Formation formation) {
        int size = formation.getSeanceFormations().size();
        int n = 0 ;
        formation.setNombreJours(size);
        formation.setTypeActivite(n);
        System.out.println(formation.getTypeActivite());
        em.persist(formation);
        formation.getSeanceFormations().forEach((seanceFormation) ->
        {   seanceFormation.setFormation(formation);
            em.persist(seanceFormation);
        });
        System.out.println("formation ");
        formation.getInstructions().forEach((instruction) ->
        {
            System.out.println(instruction.getUtilisateur().getId());
            Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            instruction.setUtilisateur(user);
            System.out.println(instruction.getUtilisateur().getId());
            instruction.setActiviteFormation(formation);

            System.out.println(instruction.getUtilisateur().getId());
            System.out.println(instruction.getActiviteFormation().getId());
            System.out.println(instruction.getPosition());
            System.out.println("avant perst");

            em.persist(instruction);
            System.out.println("aaaaa");

            System.out.println("cccc");

        });
        System.out.println("instruction ");

    }




    @Override
    public List<Formation> GetFormations() {
        List<Formation> formations=null;
        TypedQuery<Formation> query = em.createQuery("Select e from Formation e "
                , Formation.class);
        try {
            formations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return formations;
    }

    @Override
    public List<Formation> GetFormationsPNT() {
        List<Formation> formations=null;
        TypedQuery<Formation> query = em.createQuery("Select e from Formation e "
                        +"where e.typeActivite = 0"
                , Formation.class);
        try {
            formations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return formations;
    }


    @Override
    public List<Formation> GetFormationsPNC() {
        List<Formation> formations=null;
        TypedQuery<Formation> query = em.createQuery("Select e from Formation e "
                        +"where e.typeActivite = 1"
                , Formation.class);
        try {
            formations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return formations;
    }

    @Override
    public void UpdateFormation(Formation formation) {
        int size = formation.getSeanceFormations().size();
        formation.setNombreJours(size);
        formation.getSeanceFormations().forEach((seanceFormation) ->
        {seanceFormation.setFormation(formation);
        });
        em.merge(formation);
        formation.getInstructions().forEach((instruction) ->
        {
            System.out.println(instruction.getUtilisateur().getId());
            Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            instruction.setUtilisateur(user);
            System.out.println(instruction.getUtilisateur().getId());
            instruction.setActiviteFormation(formation);

            System.out.println(instruction.getUtilisateur().getId());
            System.out.println(instruction.getActiviteFormation().getId());
            System.out.println(instruction.getPosition());
            System.out.println("avant perst");

            em.persist(instruction);});
    }

    @Override
    public void deleteFormation(int idFormation) {
        em.remove(em.find(Formation.class, idFormation));
    }

    @Override
    public Formation getFormationById(int idFormation){
        return em.find(Formation.class, idFormation);

    }


    @Override
    public List<Instruction> SelectInstructionsByActiviteFormation(Integer idFormation) {

        List<Instruction> instructions=null;
        TypedQuery<Instruction> query = em.createQuery("Select e from Instruction e where e.activiteFormation="+idFormation
                , Instruction.class);
        try {
            instructions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return instructions;

    }

    @Override
    public void deleteInstructionByActiviteAndUser(int idActiviteFormation, int idUser) {
        TypedQuery<Instruction> query = em.createQuery("Select p from Instruction p  "
                        +"where p.id.idUtilisateur=:idUser and "
                        +"p.id.idActiviteFormation=:idActiviteFormation"
                , Instruction.class);

        query.setParameter("idUser",idUser);
        query.setParameter("idActiviteFormation",idActiviteFormation);

        Instruction instruction = null ;
        instruction = query.getSingleResult();
        em.remove(instruction);

    }

    @Override
    public void deleteSeanceFormation(int idSeanceFormation) {
        em.remove(em.find(SeanceFormation.class, idSeanceFormation));
        System.out.println(idSeanceFormation);
        System.out.println("removed");

    }


}
