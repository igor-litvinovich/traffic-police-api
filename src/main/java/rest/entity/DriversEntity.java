package rest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "drivers")
public class DriversEntity {
    private String id;
    private String driverFio;
    private Date driverBirthdate;
    private String driverAdress;
    private String driverPassport;
    private String driverRules;
    private Date driverRulesDate;
    private String driverCategory;
    private Date createdAt;
    private Date updatedAt;
    private Collection<CarEntity> amsById;
    private JackedCarsEntity jackedCarsByJackedCarId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DRIVER_FIO")
    public String getDriverFio() {
        return driverFio;
    }

    public void setDriverFio(String driverFio) {
        this.driverFio = driverFio;
    }

    @Basic
    @Column(name = "DRIVER_BIRTHDATE")
    public Date getDriverBirthdate() {
        return driverBirthdate;
    }

    public void setDriverBirthdate(Date driverBirthdate) {
        this.driverBirthdate = driverBirthdate;
    }

    @Basic
    @Column(name = "DRIVER_ADRESS")
    public String getDriverAdress() {
        return driverAdress;
    }

    public void setDriverAdress(String driverAdress) {
        this.driverAdress = driverAdress;
    }

    @Basic
    @Column(name = "DRIVER_PASSPORT")
    public String getDriverPassport() {
        return driverPassport;
    }

    public void setDriverPassport(String driverPassport) {
        this.driverPassport = driverPassport;
    }

    @Basic
    @Column(name = "DRIVER_RULES")
    public String getDriverRules() {
        return driverRules;
    }

    public void setDriverRules(String driverRules) {
        this.driverRules = driverRules;
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

        DriversEntity that = (DriversEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (driverFio != null ? !driverFio.equals(that.driverFio) : that.driverFio != null) return false;
        if (driverBirthdate != null ? !driverBirthdate.equals(that.driverBirthdate) : that.driverBirthdate != null)
            return false;
        if (driverAdress != null ? !driverAdress.equals(that.driverAdress) : that.driverAdress != null) return false;
        if (driverPassport != null ? !driverPassport.equals(that.driverPassport) : that.driverPassport != null)
            return false;
        if (driverRules != null ? !driverRules.equals(that.driverRules) : that.driverRules != null) return false;
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
        result = 31 * result + (driverFio != null ? driverFio.hashCode() : 0);
        result = 31 * result + (driverBirthdate != null ? driverBirthdate.hashCode() : 0);
        result = 31 * result + (driverAdress != null ? driverAdress.hashCode() : 0);
        result = 31 * result + (driverPassport != null ? driverPassport.hashCode() : 0);
        result = 31 * result + (driverRules != null ? driverRules.hashCode() : 0);
        result = 31 * result + (driverRulesDate != null ? driverRulesDate.hashCode() : 0);
        result = 31 * result + (driverCategory != null ? driverCategory.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "driversByDriverId")
    public Collection<CarEntity> getAmsById() {
        return amsById;
    }

    public void setAmsById(Collection<CarEntity> amsById) {
        this.amsById = amsById;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "jackedCarId", referencedColumnName = "id")
    public JackedCarsEntity getJackedCarsByJackedCarId() {
        return jackedCarsByJackedCarId;
    }

    public void setJackedCarsByJackedCarId(JackedCarsEntity jackedCarsByJackedCarId) {
        this.jackedCarsByJackedCarId = jackedCarsByJackedCarId;
    }
}
