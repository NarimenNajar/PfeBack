package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.NatureFormationServiceRemote;
import tn.nouvelair.BackFormationPN.entities.NatureFormation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class NatureFormationService implements NatureFormationServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterNatureFormation(NatureFormation natureFormation) {
        em.persist(natureFormation);
    }

    @Override
    public List<NatureFormation> GetNatureFormations() {
        List<NatureFormation> natureFormations=null;
        TypedQuery<NatureFormation> query = em.createQuery("Select e from NatureFormation e "
                , NatureFormation.class);
        try {
            natureFormations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return natureFormations;
    }

    @Override
    public void UpdateNatureFormation(NatureFormation natureFormation) {
        em.merge(natureFormation);
    }

    @Override
    public void deleteNatureFormation(int idnatureFormation) {
        em.remove(em.find(NatureFormation.class, idnatureFormation));
    }
}
