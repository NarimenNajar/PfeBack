package tn.nouvelair.BackFormationPN.entities;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Description implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )

    private int id;
    private String description;

    @ManyToOne
    private Syllabus syllabus;

    @OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER,mappedBy = "description")
    @Fetch(value = FetchMode.SUBSELECT)

    private List<Detail> details;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Description() {

    }
}
