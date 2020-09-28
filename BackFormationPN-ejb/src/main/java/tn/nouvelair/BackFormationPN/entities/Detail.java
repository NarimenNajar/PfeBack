package tn.nouvelair.BackFormationPN.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;

@JsonIgnoreProperties(allowSetters = true, value = {"description"})
@Entity
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String detail;
    @ManyToOne(fetch=FetchType.LAZY)
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
