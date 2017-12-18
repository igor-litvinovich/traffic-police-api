package rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "jacked_cars")
public class JackedCarsEntity {
    private String id;
    private Date jcJackdate;
    private Date jcReportDate;
    private String jcAdditional;
    private Boolean jcFound;
    private String jcFoundDate;
    private Date driverRulesDate;
    private String driverCategory;
    private Date createdAt;
    private Date updatedAt;
    private Collection<CarEntity> amsById;
    private Collection<DriversEntity> driversById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "JC_JACKDATE")
    public Date getJcJackdate() {
        return jcJackdate;
    }

    public void setJcJackdate(Date jcJackdate) {
        this.jcJackdate = jcJackdate;
    }

    @Basic
    @Column(name = "JC_REPORT_DATE")
    public Date getJcReportDate() {
        return jcReportDate;
    }

    public void setJcReportDate(Date jcReportDate) {
        this.jcReportDate = jcReportDate;
    }

    @Basic
    @Column(name = "JC_ADDITIONAL")
    public String getJcAdditional() {
        return jcAdditional;
    }

    public void setJcAdditional(String jcAdditional) {
        this.jcAdditional = jcAdditional;
    }

    @Basic
    @Column(name = "JC_FOUND")
    public Boolean getJcFound() {
        return jcFound;
    }

    public void setJcFound(Boolean jcFound) {
        this.jcFound = jcFound;
    }

    @Basic
    @Column(name = "JC_FOUND_DATE")
    public String getJcFoundDate() {
        return jcFoundDate;
    }

    public void setJcFoundDate(String jcFoundDate) {
        this.jcFoundDate = jcFoundDate;
    }

    @Basic
    @Column(name = "DRIVER_RULES_DATE")
    public Date getDriverRulesDate() {
        return driverRulesDate;
    }

    public void setDriverRulesDate(Date driverRulesDate) {
        this.driverRulesDate = driverRulesDate;
    }

    @Basic
    @Column(name = "DRIVER_CATEGORY")
    public String getDriverCategory() {
        return driverCategory;
    }

    public void setDriverCategory(String driverCategory) {
        this.driverCategory = driverCategory;
    }

    @Basic
    @Column(name = "createdAt")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JackedCarsEntity that = (JackedCarsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (jcJackdate != null ? !jcJackdate.equals(that.jcJackdate) : that.jcJackdate != null) return false;
        if (jcReportDate != null ? !jcReportDate.equals(that.jcReportDate) : that.jcReportDate != null) return false;
        if (jcAdditional != null ? !jcAdditional.equals(that.jcAdditional) : that.jcAdditional != null) return false;
        if (jcFound != null ? !jcFound.equals(that.jcFound) : that.jcFound != null) return false;
        if (jcFoundDate != null ? !jcFoundDate.equals(that.jcFoundDate) : that.jcFoundDate != null) return false;
        if (driverRulesDate != null ? !driverRulesDate.equals(that.driverRulesDate) : that.driverRulesDate != null)
            return false;
        if (driverCategory != null ? !driverCategory.equals(that.driverCategory) : that.driverCategory != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jcJackdate != null ? jcJackdate.hashCode() : 0);
        result = 31 * result + (jcReportDate != null ? jcReportDate.hashCode() : 0);
        result = 31 * result + (jcAdditional != null ? jcAdditional.hashCode() : 0);
        result = 31 * result + (jcFound != null ? jcFound.hashCode() : 0);
        result = 31 * result + (jcFoundDate != null ? jcFoundDate.hashCode() : 0);
        result = 31 * result + (driverRulesDate != null ? driverRulesDate.hashCode() : 0);
        result = 31 * result + (driverCategory != null ? driverCategory.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "jackedCarsByJackedCarId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<CarEntity> getAmsById() {
        return amsById;
    }

    public void setAmsById(Collection<CarEntity> amsById) {
        this.amsById = amsById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "jackedCarsByJackedCarId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<DriversEntity> getDriversById() {
        return driversById;
    }

    public void setDriversById(Collection<DriversEntity> driversById) {
        this.driversById = driversById;
    }
}
