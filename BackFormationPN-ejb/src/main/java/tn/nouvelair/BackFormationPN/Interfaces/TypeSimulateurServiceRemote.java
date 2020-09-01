package tn.nouvelair.BackFormationPN.Interfaces;

import tn.nouvelair.BackFormationPN.entities.TypeFormation;
import tn.nouvelair.BackFormationPN.entities.TypeSimulateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TypeSimulateurServiceRemote {
    public void AjouterTypeSimulateur(TypeSimulateur typeSimulateur);
    public void UpdateTypeSimulateur(TypeSimulateur typeSimulateur);
    List<TypeSimulateur> GetTypeSimulateurs();
    public void deleteTypeSimulateur(int idTypeSimulateur);
}
