package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.PopulationServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Population;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class PopulationService implements PopulationServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterPopulation(Population population) {
        em.persist(population);
        // return categorie.getId();
    }

    @Override
    public List<Population> GetPopulations() {
        List<Population> populations=null;
        TypedQuery<Population> query = em.createQuery("Select e from Population e "
                , Population.class);
        try {
            populations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return populations;
    }

    @Override
    public void UpdatePopulation(Population population) {
        em.merge(population);

    }

    @Override
    public void deletePopulation(int idpopulation) {
        em.remove(em.find(Population.class, idpopulation));

    }
}
