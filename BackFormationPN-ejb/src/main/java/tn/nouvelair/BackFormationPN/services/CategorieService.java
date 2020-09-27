package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class CategorieService implements CategorieServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterCategorie(Categorie categorie) {
        em.persist(categorie);
       // return categorie.getId();
    }

    @Override
    public List<Categorie> GetCategories() {
        List<Categorie> categos=null;
        TypedQuery<Categorie> query = em.createQuery("Select e from Categorie e "
                , Categorie.class);
        try {
            categos = query.getResultList();
        } catch (NoResultException e ) {

        }
        return categos;
    }

    @Override
    public void UpdateCategorie(Categorie categorie) {
        em.merge(categorie);

    }

    @Override
    public void deleteCategorie(int idCategorie) {
        em.remove(em.find(Categorie.class, idCategorie));

    }

    @Override
    public Categorie getCategorieById(int idCategorie){
        return em.find(Categorie.class, idCategorie);

    }
}
