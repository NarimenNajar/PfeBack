package tn.nouvelair.BackFormationPN.Interfaces;

import tn.nouvelair.BackFormationPN.entities.ParametrageEcheance;


import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ParametrageEcheanceServiceRemote {
    public void AjouterParametrageEcheance(ParametrageEcheance parametrageEcheance);
    public void UpdateParametrageEcheance(ParametrageEcheance parametrageEcheance);
    List<ParametrageEcheance> GetParametrageEcheances();
    public void deleteParametrageEcheance(int idParametrageEcheance);
    public ParametrageEcheance getParametrageEcheanceById(int idParametrageEcheance);
}
