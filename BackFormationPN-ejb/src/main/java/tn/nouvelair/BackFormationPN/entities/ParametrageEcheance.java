package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.ManyToOne;


@Entity
public class ParametrageEcheance implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE )

    private int id;
    private int etapeSuivante;
    private int calculeApartir;
    private int toleranceJours;
    private boolean echeanceFinMois;
    private boolean valideParDefaut;

    public ParametrageEcheance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtapeSuivante() {
        return etapeSuivante;
    }

    public void setEtapeSuivante(int etapeSuivante) {
        this.etapeSuivante = etapeSuivante;
    }

    public int getCalculeApartir() {
        return calculeApartir;
    }

    public void setCalculeApartir(int calculeApartir) {
        this.calculeApartir = calculeApartir;
    }

    public int getToleranceJours() {
        return toleranceJours;
    }

    public void setToleranceJours(int toleranceJours) {
        this.toleranceJours = toleranceJours;
    }

    public boolean isEcheanceFinMois() {
        return echeanceFinMois;
    }

    public void setEcheanceFinMois(boolean echeanceFinMois) {
        this.echeanceFinMois = echeanceFinMois;
    }

    public boolean isValideParDefaut() {
        return valideParDefaut;
    }

    public void setValideParDefaut(boolean valideParDefaut) {
        this.valideParDefaut = valideParDefaut;
    }
}
