package tn.nouvelair.BackFormationPN.Interfaces;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.SystemeExterne;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SystemeExterneServiceRemote {
    public void AjouterSysExterne(SystemeExterne systemeExterne);
    List<SystemeExterne> GetSystemesExternes();
    public void deleteSysExterne(int idSys);
    public void UpdateSysExterne(SystemeExterne systemeExterne);
    public SystemeExterne getSysExterneById(int idSysExterne);

}
