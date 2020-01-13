package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "names_brand")
public class NamesBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Drug drug;

    public NamesBrand() {
    }

    public void setDrugForNamesBrand(Drug drug) {
        this.drug = drug;
        if (!drug.getNamesBrand().contains(this)) {
            drug.getNamesBrand().add(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
