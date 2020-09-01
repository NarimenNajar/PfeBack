package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;
import tn.nouvelair.BackFormationPN.entities.Role;

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
public class RoleService implements RoleServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterRole(Role role) {
        em.persist(role);
    }

    @Override
    public List<Role> GetRoles() {
        List<Role> roles=null;
        TypedQuery<Role> query = em.createQuery("Select e from Role e "
                , Role.class);
        try {
            roles = query.getResultList();
        } catch (NoResultException e ) {

        }
        return roles;
    }

    @Override
    public void UpdateRole(Role role) {
        em.merge(role);

    }

    @Override
    public void deleteRole(int idRole) {
        em.remove(em.find(Role.class, idRole));

    }


  /* @Override
    public List<Fonctionnalite> GetFonctionnalites(int idRole) {
        List<Fonctionnalite> fonctionnalites=null;
        TypedQuery<Fonctionnalite> query = em.createQuery("Select fonctionnalites, from Role e where e.id="+idRole
                , Fonctionnalite.class);
        try {
            fonctionnalites = query.getResultList();
        } catch (NoResultException e ) {

        }
       fonctionnalites = query.getResultList();
        return fonctionnalites;
    }*/

  @Override
  public List<Fonctionnalite> GetFonctionnalites(int idRole) {
      List<Fonctionnalite> fonctionnalites=null;
      TypedQuery<Fonctionnalite> query = em.createQuery("Select fonctionnalites, from Role e where e.id="+idRole
              , Fonctionnalite.class);

      try {
          fonctionnalites = query.getResultList();
      } catch (NoResultException e ) {

      }
      return fonctionnalites;
  }

}
