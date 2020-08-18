package tn.nouvelair.BackFormationPN.services;

import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TypeFonctionServiceRemote {

    public void AjouterTypeFonction(TypeFonction typeFonction);
    public void UpdateTypeFonction(TypeFonction typeFonction);
    List<TypeFonction> GetTypeFonctions();
    public void deleteTypeFonction(int idtypeFonction);
}
