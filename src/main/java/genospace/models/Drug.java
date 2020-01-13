package genospace.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "drug", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MechanismsMolecular> mechanismsMolecular;

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

    public void setMechanismMolecularForDrug(MechanismsMolecular molecular) {
        this.mechanismsMolecular.add(molecular);
        if (molecular.getDrug() != this)
            molecular.setDrug(this);
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

    public String getName() {
        return nameMain;
    }

    public void setName(String name) {
        this.nameMain = name;
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

    public List<MechanismsMolecular> getMechanismsMolecular() {
        return mechanismsMolecular;
    }

    public void setMechanismsMolecular(List<MechanismsMolecular> mechanismsMolecular) {
        this.mechanismsMolecular = mechanismsMolecular;
    }

    public List<DevelopmentStatusSummary> getDevelopmentStatusSummary() {
        return developmentStatusSummary;
    }

    public void setDevelopmentStatusSummary(List<DevelopmentStatusSummary> developmentStatusSummary) {
        this.developmentStatusSummary = developmentStatusSummary;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", nameMain='" + nameMain + '\'' +
                ", nameGeneric='" + nameGeneric + '\'' +
                ", namesCode=" + namesCode +
                ", namesBrand=" + namesBrand +
                ", mechanismsMolecular=" + mechanismsMolecular +
                ", developmentStatusSummary=" + developmentStatusSummary +
                '}';
    }
}
