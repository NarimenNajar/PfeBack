package tn.nouvelair.BackFormationPN.services;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Fonctionnalite;
import tn.nouvelair.BackFormationPN.entities.Role;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RoleServiceRemote {
    public void AjouterRole(Role role);
    public void UpdateRole(Role role);
    List<Role> GetRoles();
    public void deleteRole(int idRole);
    public List<Fonctionnalite> GetFonctionnalites(int idRole);
}
