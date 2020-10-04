package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.NatureFormation;
import tn.nouvelair.BackFormationPN.entities.TypeFormation;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface NatureFormationServiceRemote {
    public void AjouterNatureFormation(NatureFormation natureFormation);
    public void UpdateNatureFormation(NatureFormation natureFormation);
    List<NatureFormation> GetNatureFormations();
    public void deleteNatureFormation(int idNatureFormation);
    public NatureFormation getNatureFormationById(int idNatureFormation);
}
