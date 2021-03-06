package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.ExerciceServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Exercice;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

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
public class ExerciceService implements ExerciceServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterExercice(Exercice exercice) {
        em.persist(exercice);

    }

    @Override
    public List<Exercice> GetExercices() {
        List<Exercice> exercices=null;
        TypedQuery<Exercice> query = em.createQuery("Select e from Exercice e "
                , Exercice.class);
        try {
            exercices = query.getResultList();
        } catch (NoResultException e ) {

        }
        return exercices;
    }

    @Override
    public void UpdateExercice(Exercice exercice) {
        em.merge(exercice);

    }

    @Override
    public void deleteExercice(int idExercice) {
        em.remove(em.find(Exercice.class, idExercice));

    }

    @Override
    public Exercice getExerciceIdBySyllabusAndTitle(String exercice, int syllabusID) {
        TypedQuery<Exercice> query = em.createQuery("Select p from Exercice p  "
                        +"where p.exercice=:exercice and "
                        +"p.syllabus_id=:syllabusID"
                , Exercice.class);

        query.setParameter("exercice",exercice);
        query.setParameter("syllabusID",syllabusID);

        Exercice ex = null ;
        ex = query.getSingleResult();


        return ex;
    }
}
