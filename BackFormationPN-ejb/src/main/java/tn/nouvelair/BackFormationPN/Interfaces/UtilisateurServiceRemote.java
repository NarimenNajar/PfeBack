package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UtilisateurServiceRemote {



    public void AjouterUtilisateur(Utilisateur utilisateur);
    public Utilisateur getUserByEmailAndPassword(String codePN, int cin);
    List<Utilisateur> GetUsers();
    public void updateUtilisateur(Utilisateur utilisateur);
    //public List<Utilisateur> SelectUsersByCategorie(Categorie categorie);
    public List<Utilisateur> SelectUsersByCategorie(Integer idCategorie);
    public List<Utilisateur> SelectUsersByRole(Integer idRole);
    public void deleteUser(int idUser);
    public Utilisateur getUtilisateurById(int idUtilisateur);


}
