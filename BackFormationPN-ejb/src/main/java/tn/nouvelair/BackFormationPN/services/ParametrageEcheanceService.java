package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.ParametrageEcheanceServiceRemote;
import tn.nouvelair.BackFormationPN.entities.ParametrageEcheance;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class ParametrageEcheanceService implements ParametrageEcheanceServiceRemote {

    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterParametrageEcheance(ParametrageEcheance parametrageEcheance) {
        em.persist(parametrageEcheance);

    }

    @Override
    public List<ParametrageEcheance> GetParametrageEcheances() {
        List<ParametrageEcheance> parametrageEcheances=null;
        TypedQuery<ParametrageEcheance> query = em.createQuery("Select e from ParametrageEcheance e "
                , ParametrageEcheance.class);
        try {
            parametrageEcheances = query.getResultList();
        } catch (NoResultException e ) {

        }
        return parametrageEcheances;
    }

    @Override
    public void UpdateParametrageEcheance(ParametrageEcheance parametrageEcheance) {
        em.merge(parametrageEcheance);

    }

    @Override
    public void deleteParametrageEcheance(int idParametrageEcheance) {
        em.remove(em.find(ParametrageEcheance.class, idParametrageEcheance));

    }

    @Override
    public ParametrageEcheance getParametrageEcheanceById(int idParametrageEcheance){
        return em.find(ParametrageEcheance.class, idParametrageEcheance);

    }


}
