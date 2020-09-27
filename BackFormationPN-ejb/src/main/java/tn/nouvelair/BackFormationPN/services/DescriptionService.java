package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.Interfaces.DescriptionServiceRemote;
import tn.nouvelair.BackFormationPN.entities.Description;
import tn.nouvelair.BackFormationPN.entities.Exercice;

import javax.crypto.spec.DESedeKeySpec;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class DescriptionService implements DescriptionServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterDescription(Description description) {
        em.persist(description);
    }

    @Override
    public List<Description> GetDescriptions() {
        List<Description> descs=null;
        TypedQuery<Description> query = em.createQuery("Select e from Description e "
                , Description.class);
        try {
            descs = query.getResultList();
        } catch (NoResultException e ) {

        }
        return descs;
    }

    @Override
    public void UpdateDescription(Description description) {
        em.merge(description);

    }

    @Override
    public void deleteDescription(int idDescription) {
        em.remove(em.find(Description.class, idDescription));

    }

    @Override
    public Description getDescriptionIdBySyllabusAndTitle(String description, int syllabusID) {
        TypedQuery<Description> query = em.createQuery("Select p from Description p  "
                        +"where p.description=:description and "
                        +"p.syllabus_id=:syllabusID"
                , Description.class);

        query.setParameter("description",description);
        query.setParameter("syllabusID",syllabusID);

        Description desc = null ;
        desc = query.getSingleResult();


        return desc;
    }
}
