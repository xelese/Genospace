package genospace.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mechanism")
public class Mechanism {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "mechanism", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MechanismsMolecular> mechanismsMolecular;

    public Mechanism() {
    }

    public void setMechanismMolecularForMechanism(MechanismsMolecular molecular) {
        this.mechanismsMolecular.add(molecular);
        if (molecular.getMechanism() != this)
            molecular.setMechanism(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MechanismsMolecular> getMechanismsMolecular() {
        return mechanismsMolecular;
    }

    public void setMechanismsMolecular(List<MechanismsMolecular> mechanismsMolecular) {
        this.mechanismsMolecular = mechanismsMolecular;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    @Override
    public String toString() {
        return "Mechanism{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mechanismsMolecular=" + mechanismsMolecular +
                '}';
    }
}
