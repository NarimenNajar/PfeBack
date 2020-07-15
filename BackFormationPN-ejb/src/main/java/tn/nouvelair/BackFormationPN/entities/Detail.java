package tn.nouvelair.BackFormationPN.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )

    private int id;
    private String detail;
    @ManyToOne
    private Description description;


    public Detail() {

    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
