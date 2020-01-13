package genospace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administration_routes")
public class AdministrationRoutes {

    @Id
    private Integer id;

    private String description;

    @ManyToOne
    @JsonIgnore
    private DevelopmentStatusSummary developmentStatusSummary;

    public AdministrationRoutes() {
    }

    public void setDSSForAr(DevelopmentStatusSummary dss) {
        this.developmentStatusSummary = dss;
        if (!dss.getAdministrationRoutesList().contains(this)) {
            dss.getAdministrationRoutesList().add(this);
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

    public DevelopmentStatusSummary getDevelopmentStatusSummary() {
        return developmentStatusSummary;
    }

    public void setDevelopmentStatusSummary(DevelopmentStatusSummary developmentStatusSummary) {
        this.developmentStatusSummary = developmentStatusSummary;
    }
}
