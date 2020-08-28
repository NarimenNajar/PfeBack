package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.entities.TypeFormation;
import tn.nouvelair.BackFormationPN.entities.TypeSimulateur;


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

public class TypeSimulateurService implements TypeSimulateurServiceRemote{
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterTypeSimulateur(TypeSimulateur typeSimulateur) {
        em.persist(typeSimulateur);
    }

    @Override
    public List<TypeSimulateur> GetTypeSimulateurs() {
        List<TypeSimulateur> typeSimulateurs=null;
        TypedQuery<TypeSimulateur> query = em.createQuery("Select e from TypeSimulateur e "
                , TypeSimulateur.class);
        try {
            typeSimulateurs = query.getResultList();
        } catch (NoResultException e ) {

        }
        return typeSimulateurs;
    }

    @Override
    public void UpdateTypeSimulateur(TypeSimulateur typeSimulateur) {
        em.merge(typeSimulateur);
    }

    @Override
    public void deleteTypeSimulateur(int idTypeSimulateur) {
        em.remove(em.find(TypeSimulateur.class, idTypeSimulateur));
    }
}
