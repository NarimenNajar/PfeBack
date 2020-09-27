package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Description;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DescriptionServiceRemote {
    public void AjouterDescription(Description description);
    public void UpdateDescription(Description description);
    List<Description> GetDescriptions();
    public void deleteDescription(int idDescription);
    public Description getDescriptionIdBySyllabusAndTitle(String description, int syllabusID);
}
