package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FonctionnaliteServiceRemote {
    public void AjouterFonctionnalite(Fonctionnalite fonctionnalite);
    public void UpdateFonctionnalite(Fonctionnalite fonctionnalite);
    List<Fonctionnalite> GetFonctionnalites();
    public void deleteFonctionnalite(int idFonctionnalite);
}
