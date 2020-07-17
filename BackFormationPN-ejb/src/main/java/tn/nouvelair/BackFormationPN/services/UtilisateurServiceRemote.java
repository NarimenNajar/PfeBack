package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UtilisateurServiceRemote {



    public void AjouterUtilisateur(Utilisateur utilisateur);
    public Utilisateur getUserByEmailAndPassword(String codePN, int cin);
    List<Utilisateur> GetUsers();





}
