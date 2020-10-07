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

}
