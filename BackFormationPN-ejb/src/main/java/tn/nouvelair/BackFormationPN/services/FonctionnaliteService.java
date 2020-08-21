package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;

import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class FonctionnaliteService implements FonctionnaliteServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterFonctionnalite(Fonctionnalite fonctionnalite) {
        em.persist(fonctionnalite);

    }

    @Override
    public List<Fonctionnalite> GetFonctionnalites() {
        List<Fonctionnalite> fonctionnalites=null;
        TypedQuery<Fonctionnalite> query = em.createQuery("Select e from Fonctionnalite e "
                , Fonctionnalite.class);
        try {
            fonctionnalites = query.getResultList();
        } catch (NoResultException e ) {

        }
        return fonctionnalites;
    }

    @Override
    public void UpdateFonctionnalite(Fonctionnalite fonctionnalite) {
        em.merge(fonctionnalite);

    }

    @Override
    public void deleteFonctionnalite(int idFonctionnalite) {
        em.remove(em.find(Fonctionnalite.class, idFonctionnalite));

    }
}
