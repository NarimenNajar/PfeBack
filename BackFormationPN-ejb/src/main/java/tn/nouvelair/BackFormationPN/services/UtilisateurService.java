package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class UtilisateurService implements UtilisateurServiceRemote {
    @PersistenceContext(unitName = "OTDAV-ejb")
    EntityManager em ;

    @Override
    public void AjouterUtilisateur(Utilisateur utilisateur) {
        em.persist(utilisateur);
    }
}
