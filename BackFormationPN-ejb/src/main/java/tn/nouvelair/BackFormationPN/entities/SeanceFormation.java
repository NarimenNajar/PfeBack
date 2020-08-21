package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;


@Entity
public class SeanceFormation  implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private int id;

    @ManyToOne
    private Formation formation;

}
