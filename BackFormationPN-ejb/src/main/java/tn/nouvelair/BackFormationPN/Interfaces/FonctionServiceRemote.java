package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Fonction;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FonctionServiceRemote {
    public void AjouterFonction(Fonction fonction);
    public void UpdateFonction(Fonction fonction);
    List<Fonction> GetFonctions();
    public void deleteFonction(int idFonction);
}
