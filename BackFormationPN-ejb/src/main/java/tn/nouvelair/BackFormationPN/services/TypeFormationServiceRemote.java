package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;
import tn.nouvelair.BackFormationPN.entities.TypeFormation;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TypeFormationServiceRemote {
    public void AjouterTypeFormation(TypeFormation typeFormation);
    public void UpdateTypeFormation(TypeFormation typeFormation);
    List<TypeFormation> GetTypeFormations();
    public void deleteTypeFormation(int idtypeFormation);
}
