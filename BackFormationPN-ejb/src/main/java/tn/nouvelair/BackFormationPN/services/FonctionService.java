package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.Interfaces.FonctionServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Fonction;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class FonctionService implements FonctionServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterFonction(Fonction fonction) {
        em.persist(fonction);

    }

    @Override
    public List<Fonction> GetFonctions() {
        List<Fonction> fonctions=null;
        TypedQuery<Fonction> query = em.createQuery("Select e from Fonction e "
                , Fonction.class);
        try {
            fonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctions;
    }

    @Override
    public void UpdateFonction(Fonction fonction) {
        em.merge(fonction);

    }

    @Override
    public void deleteFonction(int idFonction) {
        em.remove(em.find(Fonction.class, idFonction));

    }
}
