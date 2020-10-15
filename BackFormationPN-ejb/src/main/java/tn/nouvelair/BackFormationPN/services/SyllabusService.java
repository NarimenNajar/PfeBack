package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.ExerciceServiceRemote;
import tn.nouvelair.BackFormationPN.Interfaces.SyllabusServiceRemote;
import tn.nouvelair.BackFormationPN.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Stateless
@LocalBean
public class SyllabusService implements SyllabusServiceRemote {
    ExerciceServiceRemote e;
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;


    @Override
    public void AjouterSyllabus(Syllabus syllabus) {


        em.persist(syllabus);

        //syllabus.getExercices().forEach((exercice) ->  System.out.println(exercice.getExercice()));

        /// Les Exercices
        syllabus.getExercices().forEach((exercice) ->
        {   exercice.setSyllabus(syllabus);
            em.persist(exercice);
        });
        System.out.println("test ex ");

        // Les descriptions
        syllabus.getDescriptions().forEach((description) ->
        {   description.setSyllabus(syllabus);
            em.persist(description);
            //description.getDetails().forEach(detail);
            description.getDetails().forEach((detail) ->
            {   detail.setDescription(description);
                em.persist(detail);
                System.out.println("test detail ");

            });
        });
        System.out.println("test desc");

        // Les competences
        syllabus.getCompetences().forEach((competence) ->
        {   competence.setSyllabus(syllabus);
            em.persist(competence);
        });
        System.out.println("test competences");

        // Les parties
        syllabus.getParties().forEach((partie) ->
        {   partie.setSyllabus(syllabus);
            em.persist(partie);
            partie.getTaches().forEach((tache) ->
            {   tache.setPartie(partie);
                em.persist(tache);
                System.out.println("test tache ");

            });
        });
        System.out.println("test parties");
    }

    @Override
    public List<Syllabus> GetSyllabuss() {
        List<Syllabus> syllabuss=null;
        TypedQuery<Syllabus> query = em.createQuery("Select e from Syllabus e "
                , Syllabus.class);
        try {
            syllabuss = query.getResultList();
        } catch (NoResultException e ) {

        }
        return syllabuss;
    }

    @Override
    public void UpdateSyllabus(Syllabus syllabus) {


        em.merge(syllabus);

        syllabus.getExercices().forEach((exercice) ->
        {

       exercice.setSyllabus(syllabus);
            em.merge(exercice);
        });
        System.out.println("test ex ");

        // Les descriptions
        syllabus.getDescriptions().forEach((description) ->
        {   description.setSyllabus(syllabus);
            em.merge(description);
            //description.getDetails().forEach(detail);
            description.getDetails().forEach((detail) ->
            {   detail.setDescription(description);
                em.merge(detail);
                System.out.println("test detail ");

            });
        });
        System.out.println("test desc");

        // Les competences
        syllabus.getCompetences().forEach((competence) ->
        {   competence.setSyllabus(syllabus);
            em.merge(competence);
        });
        System.out.println("test competences");

        // Les parties
        syllabus.getParties().forEach((partie) ->
        {   partie.setSyllabus(syllabus);
            em.merge(partie);
            partie.getTaches().forEach((tache) ->
            {   tache.setPartie(partie);
                em.merge(tache);
                System.out.println("test tache ");

            });
        });
        System.out.println("test parties");







    }

    @Override
    public void deleteSyllabus(int idSyllabus) {
        em.remove(em.find(Syllabus.class, idSyllabus));

    }

    @Override
    public Syllabus getSyllabusById(int idSyllabus){
        return em.find(Syllabus.class, idSyllabus);

    }


}
