package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Exercice;
import tn.nouvelair.BackFormationPN.entities.Syllabus;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SyllabusServiceRemote {
    public void AjouterSyllabus(Syllabus syllabus);
    public void UpdateSyllabus(Syllabus syllabus);
    List<Syllabus> GetSyllabuss();
    public void deleteSyllabus(int idSyllabus);
    public Syllabus getSyllabusById(int idSyllabus);
}
