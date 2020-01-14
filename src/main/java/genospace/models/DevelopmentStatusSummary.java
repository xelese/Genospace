package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents the Development summary table.
 */
@Entity
@Table(name = "development_status_summary")
public class DevelopmentStatusSummary {

    @Id
    private Integer conditionId;

    private String conditionDescription;

    private Boolean conditionInActiveDevelopment;

    private Integer year;

    private Integer phaseHighestId;

    private String phaseHighestDescription;

    @ManyToOne
    @JsonIgnore
    private Drug drug;

    @OneToMany(mappedBy = "developmentStatusSummary", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AdministrationRoutes> administrationRoutesList;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Organizations> organizations;


    public DevelopmentStatusSummary() {
    }

    public void setARForDSS(AdministrationRoutes ar) {
        this.administrationRoutesList.add(ar);
        if (ar.getDevelopmentStatusSummary() != this)
            ar.setDevelopmentStatusSummary(this);
    }

    public void setOrgForDSS(Organizations org) {
        this.organizations.add(org);
        if (!org.getDevelopmentStatusSummary().contains(this))
            org.getDevelopmentStatusSummary().add(this);
    }

    public void setDrugForDSS(Drug drug) {
        this.drug = drug;
        if (!drug.getDevelopmentStatusSummary().contains(this)) {
            drug.getDevelopmentStatusSummary().add(this);
        }
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public Boolean getConditionInActiveDevelopment() {
        return conditionInActiveDevelopment;
    }

    public void setConditionInActiveDevelopment(Boolean conditionInActiveDevelopment) {
        this.conditionInActiveDevelopment = conditionInActiveDevelopment;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPhaseHighestId() {
        return phaseHighestId;
    }

    public void setPhaseHighestId(Integer phaseHighestId) {
        this.phaseHighestId = phaseHighestId;
    }

    public String getPhaseHighestDescription() {
        return phaseHighestDescription;
    }

    public void setPhaseHighestDescription(String phaseHighestDescription) {
        this.phaseHighestDescription = phaseHighestDescription;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public List<AdministrationRoutes> getAdministrationRoutesList() {
        return administrationRoutesList;
    }

    public void setAdministrationRoutesList(List<AdministrationRoutes> administrationRoutesList) {
        this.administrationRoutesList = administrationRoutesList;
    }

    public List<Organizations> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organizations> organizations) {
        this.organizations = organizations;
    }

}
