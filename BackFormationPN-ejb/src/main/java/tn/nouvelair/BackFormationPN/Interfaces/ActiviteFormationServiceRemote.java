package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.*;


import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ActiviteFormationServiceRemote {

    public void AjouterFormation(Formation formation);
    public void UpdateFormation(Formation formation);
    List<Formation> GetFormations();
    public void deleteFormation(int idFormation);
    public Formation getFormationById(int idFormation);
    public void AjouterSimulateur(Simulateur simulateur);
    public void UpdateSimulateur(Simulateur simulateur);
    List<Simulateur> GetSimulateurs();
    public void deleteSimulateur(int idSimulateur);
    public Simulateur getSimulateurById(int idSimulateur);
    public void deleteSeanceSimulateur(int idSeanceSimulateur);
    public List<Formation> GetFormationsPNT();
    public List<Formation> GetFormationsPNC();
    public void AjouterFormationPNC(Formation formation);
    public void AjouterFormationPNT(Formation formation);
    public List<Instruction> SelectInstructionsByActiviteFormation(Integer idFormation);
    public void deleteInstructionByActiviteAndUser(int idActiviteFormation, int idUser);
    public void deleteSeanceFormation(int idSeanceFormation);
    public void AjouterInstruction(Instruction instruction, int idActiviteFormation, int idUtilisateur);
    public void ValiderInstructeurSimuulateur(SeanceSimulateur seanceSimulateur);
    public SeanceSimulateur getSeanceSimulateurById(int idSeanceSimulateur);
    public List<Level> SelectLevelsBySeanceSimulateur(Integer idSeanceSimulateur);
    public List<Note> SelectNotesBySeanceSimulateur(Integer idSeanceSimulateur);
    public void AjouterLevel(Level level, int idSeanceSimulateur, int idTache);
    public void AjouterNote(Note note1, int idSeanceSimulateur, int idCompetence);
    public Instruction getSeanceSimulateurInstructor(int idActiviteFormation);
    public Instruction getSeanceSimulateurTrainee(int idActiviteFormation);
    public ActiviteFormation getSimulateurBySeanceSimulateur(int idSeanceSimulateur);
    public void ValiderTraineeSimuulateur(SeanceSimulateur seanceSimulateur);
    public void ReclamerTraineeSimuulateur(SeanceSimulateur seanceSimulateur);
    public List<Reclamation> GetReclamationsNonTraitee();
    public List<Reclamation> GetReclamationsTraitee();
    public List<Reclamation> GetReclamations();
    public void TraiterReclamation(Reclamation reclamation);
    public List<SeanceSimulateur> GetSeanceSimulateurs();
    public List<Note> GetNotes();
    public List<Level> GetLevels();
}
