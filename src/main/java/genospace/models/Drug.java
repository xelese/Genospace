package genospace.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents the drug table.
 */
@Entity
@Table(name = "drug")
public class Drug {

    @Id
    private Integer id;

    private String nameMain;

    private String nameGeneric;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NamesCode> namesCode;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NamesBrand> namesBrand;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<Mechanism> mechanism;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DevelopmentStatusSummary> developmentStatusSummary;

    public Drug() {
    }

    public void setNamesCodesForDrug(NamesCode nameCodes) {
        this.namesCode.add(nameCodes);
        if (nameCodes.getDrug() != this)
            nameCodes.setDrug(this);
    }

    public void setNameBrandsForDrug(NamesBrand namesBrand) {
        this.namesBrand.add(namesBrand);
        if (namesBrand.getDrug() != this)
            namesBrand.setDrug(this);
    }

    public void setMechanismForDrug(Mechanism mechanism) {
        if (!this.mechanism.contains(mechanism)) {
            this.mechanism.add(mechanism);
        }
        if (!mechanism.getDrug().contains(this))
            mechanism.getDrug().add(this);
    }

    public void setDSSForDrug(DevelopmentStatusSummary dss) {
        this.developmentStatusSummary.add(dss);
        if (dss.getDrug() != this)
            dss.setDrug(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGeneric() {
        return nameGeneric;
    }

    public void setNameGeneric(String nameGeneric) {
        this.nameGeneric = nameGeneric;
    }

    public List<NamesCode> getNamesCode() {
        return namesCode;
    }

    public void setNamesCode(List<NamesCode> namesCode) {
        this.namesCode = namesCode;
    }

    public List<NamesBrand> getNamesBrand() {
        return namesBrand;
    }

    public void setNamesBrand(List<NamesBrand> namesBrand) {
        this.namesBrand = namesBrand;
    }


    public List<DevelopmentStatusSummary> getDevelopmentStatusSummary() {
        return developmentStatusSummary;
    }

    public void setDevelopmentStatusSummary(List<DevelopmentStatusSummary> developmentStatusSummary) {
        this.developmentStatusSummary = developmentStatusSummary;
    }

    public String getNameMain() {
        return nameMain;
    }

    public void setNameMain(String nameMain) {
        this.nameMain = nameMain;
    }

    public List<Mechanism> getMechanism() {
        return mechanism;
    }

    public void setMechanism(List<Mechanism> mechanism) {
        this.mechanism = mechanism;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", nameMain='" + nameMain + '\'' +
                ", nameGeneric='" + nameGeneric + '\'' +
                ", namesCode=" + namesCode +
                ", namesBrand=" + namesBrand +
                ", mechanism=" + mechanism +
                ", developmentStatusSummary=" + developmentStatusSummary +
                '}';
    }
}
