package tn.nouvelair.BackFormationPN.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity

public class NumTel implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String numeroTel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
