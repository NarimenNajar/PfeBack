package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.ExerciceServiceRemote;
import tn.nouvelair.BackFormationPN.Interfaces.SyllabusServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Exercice;
import tn.nouvelair.BackFormationPN.entities.Syllabus;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class SyllabusService implements SyllabusServiceRemote {
    ExerciceServiceRemote e;
    @PersistenceContext(unitName = "OTDAV-ejb")

    EntityManager em ;

    @Override
    public void AjouterSyllabus(Syllabus syllabus) {
        em.persist(syllabus);

        syllabus.getExercices().forEach((exercice) ->  System.out.println(exercice.getExercice()));

        syllabus.getExercices().forEach((exercice) ->
        {   exercice.setSyllabus(syllabus);
            em.persist(exercice);
        });
        System.out.println("bagraaaaaaaaa");

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

    }

    @Override
    public void deleteSyllabus(int idSyllabus) {
        em.remove(em.find(Syllabus.class, idSyllabus));

    }
}
