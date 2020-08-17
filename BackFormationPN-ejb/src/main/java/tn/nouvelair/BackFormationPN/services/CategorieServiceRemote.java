package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CategorieServiceRemote {

    public void AjouterCategorie(Categorie categorie);
    public void UpdateCategorie(Categorie categorie);
    List<Categorie> GetCategories();
    public void deleteCategorie(int idCategorie);

}
