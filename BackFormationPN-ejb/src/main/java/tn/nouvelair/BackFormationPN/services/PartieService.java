package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.PartieServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Partie;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class PartieService implements PartieServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterPartie(Partie partie) {
        em.persist(partie);
        // return categorie.getId();
    }

    @Override
    public List<Partie> GetParties() {
        List<Partie> parties=null;
        TypedQuery<Partie> query = em.createQuery("Select e from Partie e "
                , Partie.class);
        try {
            parties = query.getResultList();
        } catch (NoResultException e ) {

        }
        return parties;
    }

    @Override
    public void UpdatePartie(Partie partie) {
        em.merge(partie);

    }

    @Override
    public void deletePartie(int idPartie) {
        em.remove(em.find(Partie.class, idPartie));

    }
}
