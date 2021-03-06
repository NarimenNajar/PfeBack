package tn.nouvelair.BackFormationPN.Interfaces;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonction;
import tn.nouvelair.BackFormationPN.entities.Instruction;
import tn.nouvelair.BackFormationPN.entities.Utilisateur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UtilisateurServiceRemote {



    public void AjouterUtilisateur(Utilisateur utilisateur);
    public Utilisateur getUserByEmailAndPassword(String codePN, int cin);
    List<Utilisateur> GetUsers();
    public void updateUtilisateur(Utilisateur utilisateur);
    //public List<Utilisateur> SelectUsersByCategorie(Categorie categorie);
    public List<Utilisateur> SelectUsersByCategorie(Integer idCategorie);
    public List<Utilisateur> SelectUsersByRole(Integer idRole);
    public void deleteUser(int idUser);
    public Utilisateur getUtilisateurById(int idUtilisateur);
    public List<Instruction> SelectInstructionsByUser(Integer idUtilisateur);
    public List<Instruction> SelectInstructionsByInstructor(Integer idUtilisateur);
    public List<Instruction> SelectInstructionsByTrainee(Integer idUtilisateur);
    public List<Instruction> SelectArchiveInstructions(Integer idUtilisateur);
    public List<Fonction> SelectFonctionsByUser(Integer idUtilisateur);
    public List<Fonction> SelectArchiveFonctions(Integer idUtilisateur);
    public List<Fonction> SelectCurrentFonctions(Integer idUtilisateur);
    public boolean logout();
    public boolean login(Utilisateur u) throws Exception;
    public Utilisateur getUserByCodePN(String codePN);
    public List<Instruction> SelectAlerteMyInstructionsEcheance(Integer idUtilisateur);
    public List<Instruction> SelectAlerteAllInstructionsEcheance();
    public List<Instruction> SelectAlerteAllInstructionsFinTolerEcheance();
    public List<Instruction> SelectAlerteMyInstructionsFinTolerEcheance(Integer idUtilisateur);
    public List<Instruction> SelectTodayInstructions(Integer idUtilisateur);
    public List<Instruction> SelectTodayInstructionsInstructor(Integer idUtilisateur);
    public List<Instruction> SelectTodayInstructionsTrainee(Integer idUtilisateur);
    public Instruction SelectInstructionsByActiviteAsInstructor(Integer idActivite);
    public Instruction SelectInstructionsByActiviteAsTrainee(Integer idActivite);
}
