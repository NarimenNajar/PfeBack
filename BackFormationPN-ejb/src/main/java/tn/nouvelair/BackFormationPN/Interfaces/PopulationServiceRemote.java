package tn.nouvelair.BackFormationPN.Interfaces;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Population;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PopulationServiceRemote {
    public void AjouterPopulation(Population population);
    public void UpdatePopulation(Population population);
    List<Population> GetPopulations();
    public void deletePopulation(int idPopulation);
}
