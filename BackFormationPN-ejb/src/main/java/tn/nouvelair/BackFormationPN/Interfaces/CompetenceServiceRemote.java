package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Competence;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CompetenceServiceRemote {
    public void AjouterCompetence(Competence competence);
    public void UpdateCompetence(Competence competence);
    List<Competence> GetCompetences();
    public void deleteCompetence(int idCompetence);
}
