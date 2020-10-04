package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.Interfaces.TypeFormationServiceRemote;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;
import tn.nouvelair.BackFormationPN.entities.TypeFormation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class TypeFormationService implements TypeFormationServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterTypeFormation(TypeFormation typeFormation) {
        em.persist(typeFormation);
    }

    @Override
    public List<TypeFormation> GetTypeFormations() {
        List<TypeFormation> typeFormations=null;
        TypedQuery<TypeFormation> query = em.createQuery("Select e from TypeFormation e "
                , TypeFormation.class);
        try {
            typeFormations = query.getResultList();
        } catch (NoResultException e ) {

        }
        return typeFormations;
    }

    @Override
    public void UpdateTypeFormation(TypeFormation typeFormation) {
        em.merge(typeFormation);
    }

    @Override
    public void deleteTypeFormation(int idtypeFormation) {
        em.remove(em.find(TypeFormation.class, idtypeFormation));
    }

    @Override
    public TypeFormation getTypeFormationById(int idTypeFormation){
        return em.find(TypeFormation.class, idTypeFormation);

    }
}
