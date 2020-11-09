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
        int size = simulateur.getSeanceSimulateurs().size();
        int n = 0 ;
        simulateur.setNombreJours(size);
        simulateur.setTypeActivite(n);
        em.persist(simulateur);
        simulateur.getSeanceSimulateurs().forEach((seanceSimulateur) ->
        {   seanceSimulateur.setSimulateur(simulateur);
            em.persist(seanceSimulateur);
           /* System.out.println(seanceSimulateur.getId());
            Syllabus syllabus= seanceSimulateur.getSyllabus();
            System.out.println(seanceSimulateur.getSyllabus().getId());
            syllabus.getCompetences().forEach((competence) -> {
                Note note= new Note();
                System.out.println("note");
                SeanceSimulateur seanceSimulateur1 = em.find(SeanceSimulateur.class, seanceSimulateur.getId());
                note.setSeanceSimulateur(seanceSimulateur1);
                System.out.println(note.getSeanceSimulateur().getId());
                System.out.println(competence.getId());
                Competence competence1 = em.find(Competence.class, competence.getId());
                note.setCompetence(competence1);

                System.out.println("avant persist");
                em.persist(note);
                System.out.println("after persist");

            });*/
           /* syllabus.getParties().forEach((partie) -> partie.getTaches().forEach((tache) -> {
                Level level = new Level();
                SeanceSimulateur seanceSimulateur1 = em.find(SeanceSimulateur.class, seanceSimulateur.getId());
                level.setSeanceSimulateur(seanceSimulateur1);
                Tache tache1 = em.find(Tache.class, tache.getId());
                level.setTache(tache1);
                em.persist(level);
            }));*/
        });
        System.out.println("simulateur ");
        simulateur.getInstructions().forEach((instruction) ->
        {
            System.out.println(instruction.getUtilisateur().getId());
            Utilisateur user = em.find(Utilisateur.class,instruction.getUtilisateur().getId());
            instruction.setUtilisateur(user);
            System.out.println(instruction.getUtilisateur().getId());
            instruction.setActiviteFormation(simulateur);

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
        int size = simulateur.getSeanceSimulateurs().size();
        simulateur.setNombreJours(size);
        simulateur.getSeanceSimulateurs().forEach((seanceFormation) ->
        {seanceFormation.setSimulateur(simulateur);
        });
        System.out.println("before merge simul");
        em.merge(simulateur);
        System.out.println("after merge simul");


    }

    @Override
    public void deleteSimulateur(int idSimulateur) {
        em.remove(em.find(Simulateur.class, idSimulateur));
    }

    @Override
    public Simulateur getSimulateurById(int idSimulateur){
        return em.find(Simulateur.class, idSimulateur);

    }

    @Override
    public void deleteSeanceSimulateur(int idSeanceSimulateur) {
        em.remove(em.find(SeanceSimulateur.class, idSeanceSimulateur));
        System.out.println(idSeanceSimulateur);
        System.out.println("removed");

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
    public SeanceSimulateur getSeanceSimulateurById(int idSeanceSimulateur){
        return em.find(SeanceSimulateur.class, idSeanceSimulateur);

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


    }

    @Override
    public void AjouterInstruction(Instruction instruction, int idActiviteFormation, int idUtilisateur) {
        instruction.getId().setIdUtilisateur(idUtilisateur);

       instruction.getId().setIdActiviteFormation(idActiviteFormation);
        Utilisateur user = em.find(Utilisateur.class, idUtilisateur);
        instruction.setUtilisateur(user);
        ActiviteFormation activiteFormation = em.find(ActiviteFormation.class, idActiviteFormation);
        instruction.setActiviteFormation(activiteFormation);
        em.persist(instruction);
        instruction.getUtilisateur().getInstructions().add(instruction);
        instruction.getActiviteFormation().getInstructions().add(instruction);

    }


    // mezzelet ne9sa
    @Override
    public void ValiderInstructeurSimuulateur(SeanceSimulateur seanceSimulateur)
    {
        if (seanceSimulateur.getResultFinal().equals("SATISFACTORY") )
        {
            seanceSimulateur.setValidationInstructeur(2);
        }
        if (seanceSimulateur.getResultFinal().equals("UNSATISFACTORY") )
        {
            seanceSimulateur.setValidationInstructeur(1);
        }
        em.merge(seanceSimulateur);
    }

    @Override
    public void ValiderTraineeSimuulateur(SeanceSimulateur seanceSimulateur)
    {
        seanceSimulateur.setValidationTrainee(2);
        em.merge(seanceSimulateur);
    }

    @Override
    public void ReclamerTraineeSimuulateur(SeanceSimulateur seanceSimulateur)
    {
        seanceSimulateur.setValidationTrainee(1);
        em.merge(seanceSimulateur);
        Reclamation reclamation = new Reclamation();
        reclamation.setEtat(false);
        reclamation.setSeanceSimulateur(seanceSimulateur);
        reclamation.setDate(new java.util.Date());
        reclamation.setObjet("Simulator Result");
        reclamation.setContenu("I claim my result for the attached simulator session, please check my situation");
        em.persist(reclamation);
    }


    @Override
    public List<Note> SelectNotesBySeanceSimulateur(Integer idSeanceSimulateur) {

        List<Note> notes=null;
        TypedQuery<Note> query = em.createQuery("Select e from Note e where e.seanceSimulateur="+idSeanceSimulateur
                , Note.class);
        try {
            notes = query.getResultList();
        } catch (NoResultException e ) {

        }
        return notes;

    }

    @Override
    public List<Level> SelectLevelsBySeanceSimulateur(Integer idSeanceSimulateur) {

        List<Level> levels=null;
        TypedQuery<Level> query = em.createQuery("Select e from Level e where e.seanceSimulateur="+idSeanceSimulateur
                , Level.class);
        try {
            levels = query.getResultList();
        } catch (NoResultException e ) {

        }
        return levels;

    }

    @Override
    public void AjouterLevel(Level level1, int idSeanceSimulateur, int idTache) {
        Level level = new Level();
        level.setLevel(level1.getLevel());
        level.getId().setIdTache(idTache);

        level.getId().setIdSeanceSimulateur(idSeanceSimulateur);
        Tache tache = em.find(Tache.class, idTache);
        level.setTache(tache);
        SeanceSimulateur seanceSimulateur = em.find(SeanceSimulateur.class, idSeanceSimulateur);
        level.setSeanceSimulateur(seanceSimulateur);
        em.persist(level);
        level.getTache().getLevels().add(level);
        level.getSeanceSimulateur().getLevels().add(level);

    }

    @Override
    public void AjouterNote(Note note1, int idSeanceSimulateur, int idCompetence) {
        Note note = new Note();
        note.setNote(note1.getNote());
        note.getId().setIdCompetence(idCompetence);

        note.getId().setIdSeanceSimulateur(idSeanceSimulateur);
        Competence competence = em.find(Competence.class, idCompetence);
        note.setCompetence(competence);
        SeanceSimulateur seanceSimulateur = em.find(SeanceSimulateur.class, idSeanceSimulateur);
        note.setSeanceSimulateur(seanceSimulateur);
        em.persist(note);
        note.getCompetence().getNotes().add(note);
        note.getSeanceSimulateur().getNotes().add(note);

    }


    @Override
    public Instruction getSeanceSimulateurInstructor(int idActiviteFormation){
        TypedQuery<Instruction> query = em.createQuery("Select p from Instruction p  "
                        +"where p.id.idActiviteFormation=:idActiviteFormation and "
                        +"p.position like 'Instructor' "
                , Instruction.class);

        query.setParameter("idActiviteFormation",idActiviteFormation);

        Instruction instruction = null ;

            instruction = query.getSingleResult();

        return instruction;
    }

    @Override
    public Instruction getSeanceSimulateurTrainee(int idActiviteFormation){
        TypedQuery<Instruction> query = em.createQuery("Select p from Instruction p  "
                        +"where p.id.idActiviteFormation=:idActiviteFormation and "
                        +"p.position like 'Trainee' "
                , Instruction.class);

        query.setParameter("idActiviteFormation",idActiviteFormation);

        Instruction instruction = null ;

            instruction = query.getSingleResult();

        return instruction;
    }

    @Override
    public ActiviteFormation getSimulateurBySeanceSimulateur(int idSeanceSimulateur){
        SeanceSimulateur seanceSimulateur = null;
        seanceSimulateur = em.find(SeanceSimulateur.class, idSeanceSimulateur);
        return seanceSimulateur.getSimulateur();
    }

    @Override
    public List<Reclamation> GetReclamationsNonTraitee() {
        List<Reclamation> reclamations=null;
        TypedQuery<Reclamation> query = em.createQuery("Select e from Reclamation e "
                        +"where e.etat = false "
                , Reclamation.class);
        try {
            reclamations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return reclamations;
    }

    @Override
    public List<Reclamation> GetReclamationsTraitee() {
        List<Reclamation> reclamations=null;
        TypedQuery<Reclamation> query = em.createQuery("Select e from Reclamation e "
                        +"where e.etat = true "
                , Reclamation.class);
        try {
            reclamations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return reclamations;
    }

    @Override
    public List<Reclamation> GetReclamations() {
        List<Reclamation> reclamations=null;
        TypedQuery<Reclamation> query = em.createQuery("Select e from Reclamation e "
                , Reclamation.class);
        try {
            reclamations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return reclamations;
    }

    @Override
    public void TraiterReclamation(Reclamation reclamation)
    {
        reclamation.setEtat(true);
        em.merge(reclamation);
    }
}
