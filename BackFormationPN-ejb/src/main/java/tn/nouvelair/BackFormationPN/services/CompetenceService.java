package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.CompetenceServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Competence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class CompetenceService implements CompetenceServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
EntityManager em ;

    @Override
    public void AjouterCompetence(Competence competence) {
        em.persist(competence);
    }

    @Override
    public List<Competence> GetCompetences() {
        List<Competence> competences=null;
        TypedQuery<Competence> query = em.createQuery("Select e from Competence e "
                , Competence.class);
        try {
            competences = query.getResultList();
        } catch (NoResultException e ) {

        }
        return competences;
    }

    @Override
    public void UpdateCompetence(Competence competence) {
        em.merge(competence);

    }

    @Override
    public void deleteCompetence(int idCompetence) {
        em.remove(em.find(Competence.class, idCompetence));

    }
}
