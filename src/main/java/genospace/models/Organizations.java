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
 * This class represents the organizations table.
 */
@Entity
@Table(name = "organization")
public class Organizations {

    @Id
    private Integer id;

    private String description;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<DevelopmentStatusSummary> developmentStatusSummary;

    public Organizations() {
    }

    public void setDSSForOrg(DevelopmentStatusSummary dss) {
        this.developmentStatusSummary.add(dss);
        if (!dss.getOrganizations().contains(this)) {
            dss.getOrganizations().add(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DevelopmentStatusSummary> getDevelopmentStatusSummary() {
        return developmentStatusSummary;
    }

    public void setDevelopmentStatusSummary(List<DevelopmentStatusSummary> developmentStatusSummary) {
        this.developmentStatusSummary = developmentStatusSummary;
    }
}
