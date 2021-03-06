package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Exercice;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ExerciceServiceRemote {
    public void AjouterExercice(Exercice exercice);
    public void UpdateExercice(Exercice exercice);
    List<Exercice> GetExercices();
    public void deleteExercice(int idExercice);
    public Exercice getExerciceIdBySyllabusAndTitle(String exercice, int syllabusID);
}
