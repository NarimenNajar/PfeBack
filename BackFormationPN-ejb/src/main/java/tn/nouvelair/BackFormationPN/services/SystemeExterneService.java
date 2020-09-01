package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.Interfaces.SystemeExterneServiceRemote;
import tn.nouvelair.BackFormationPN.entities.SystemeExterne;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class SystemeExterneService implements SystemeExterneServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterSysExterne(SystemeExterne systemeExterne) {
        em.persist(systemeExterne);
        // return categorie.getId();
    }

    @Override
    public List<SystemeExterne> GetSystemesExternes() {
        List<SystemeExterne> sys=null;
        TypedQuery<SystemeExterne> query = em.createQuery("Select e from SystemeExterne e "
                , SystemeExterne.class);
        try {
            sys = query.getResultList();
        } catch (NoResultException e ) {

        }
        return sys;
    }

    @Override
    public void deleteSysExterne(int idSys) {
        em.remove(em.find(SystemeExterne.class, idSys));

    }

    @Override
    public void UpdateSysExterne(SystemeExterne systemeExterne) {
        em.merge(systemeExterne);

    }
}
