package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * This class represents the names code table.
 */
@Entity
@Table(name = "names_code")
public class NamesCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Drug drug;

    public NamesCode() {
    }

    public void setDrugForNameCode(Drug drug) {
        this.drug = drug;
        if (!drug.getNamesCode().contains(this)) {
            drug.getNamesCode().add(this);
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
