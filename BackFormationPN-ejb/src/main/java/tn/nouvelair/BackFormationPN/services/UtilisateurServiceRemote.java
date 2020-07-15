package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.Remote;

@Remote
public interface UtilisateurServiceRemote {



    public void AjouterUtilisateur(Utilisateur utilisateur);





}
