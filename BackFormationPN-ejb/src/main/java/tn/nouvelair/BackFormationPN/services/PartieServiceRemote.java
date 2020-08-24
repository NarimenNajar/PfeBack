package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Partie;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PartieServiceRemote {
    public void AjouterPartie(Partie partie);
    public void UpdatePartie(Partie partie);
    List<Partie> GetParties();
    public void deletePartie(int idPartie);
}
