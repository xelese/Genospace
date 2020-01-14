package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This class represents the mechanism table.
 */
@Entity
@Table(name = "mechanism")
public class Mechanism {

    @Id
    private Integer id;

    private String name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Drug> drug;

    public Mechanism() {
    }

    public void setDrugForMechanism(Drug drug) {
        if (!this.drug.contains(drug)) {
            this.drug.add(drug);
        }
        if (!drug.getMechanism().contains(this))
            drug.getMechanism().add(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drug> getDrug() {
        return drug;
    }

    public void setDrug(List<Drug> drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Mechanism{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drug=" + drug +
                '}';
    }
}
