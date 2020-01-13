package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "mechanism_molecular")
@IdClass(MechanismsMolecularComposite.class)
public class MechanismsMolecular {

    @Id
    @ManyToOne
    @JsonIgnore
    private Drug drug;

    @Id
    @ManyToOne
    @JsonIgnore
    private Mechanism mechanism;

    public MechanismsMolecular() {
    }

    public MechanismsMolecular(Drug drug, Mechanism mechanism) {
        setDrugForMechanismMolecular(drug);
        setMechanismForMechanismMolecular(mechanism);
    }

    public void setDrugForMechanismMolecular(Drug drug) {
        this.drug = drug;
        if (!drug.getMechanismsMolecular().contains(this)) {
            drug.getMechanismsMolecular().add(this);
        }
    }

    public void setMechanismForMechanismMolecular(Mechanism mechanism) {
        this.mechanism = mechanism;
        if (!mechanism.getMechanismsMolecular().contains(this)) {
            mechanism.getMechanismsMolecular().add(this);
        }
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Mechanism getMechanism() {
        return mechanism;
    }

    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }
}
