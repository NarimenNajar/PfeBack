package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;

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
public class TypeFonctionService implements TypeFonctionServiceRemote{
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterTypeFonction(TypeFonction typeFonction) {
        em.persist(typeFonction);
    }

    @Override
    public List<TypeFonction> GetTypeFonctions() {
        List<TypeFonction> typeFonctions=null;
        TypedQuery<TypeFonction> query = em.createQuery("Select e from TypeFonction e "
                , TypeFonction.class);
        try {
            typeFonctions = query.getResultList();
        } catch (NoResultException e ) {

        }
        return typeFonctions;
    }

    @Override
    public void UpdateTypeFonction(TypeFonction typeFonction) {
        em.merge(typeFonction);
    }

    @Override
    public void deleteTypeFonction(int idtypeFonction) {
        em.remove(em.find(TypeFonction.class, idtypeFonction));
    }


}
