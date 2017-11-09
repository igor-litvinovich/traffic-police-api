package rest.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ams")
public class CarEntity {
    private Integer id;
    private String amRegNumber;
    private String amColor;
    private Integer amBodyNumber;
    private Integer amEngineNumber;
    private Integer amTechpassportNumber;
    private Date amBirthdate;
    private Date amRegistrationDate;
    private Date createdAt;
    private Date updatedAt;
    private MarksEntity marksByMarkId;
    private DriversEntity driversByDriverId;
    private JackedCarsEntity jackedCarsByJackedCarId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AM_REG_NUMBER")
    public String getAmRegNumber() {
        return amRegNumber;
    }

    public void setAmRegNumber(String amRegNumber) {
        this.amRegNumber = amRegNumber;
    }

    @Basic
    @Column(name = "AM_COLOR")
    public String getAmColor() {
        return amColor;
    }

    public void setAmColor(String amColor) {
        this.amColor = amColor;
    }

    @Basic
    @Column(name = "AM_BODY_NUMBER")
    public Integer getAmBodyNumber() {
        return amBodyNumber;
    }

    public void setAmBodyNumber(Integer amBodyNumber) {
        this.amBodyNumber = amBodyNumber;
    }

    @Basic
    @Column(name = "AM_ENGINE_NUMBER")
    public Integer getAmEngineNumber() {
        return amEngineNumber;
    }

    public void setAmEngineNumber(Integer amEngineNumber) {
        this.amEngineNumber = amEngineNumber;
    }

    @Basic
    @Column(name = "AM_TECHPASSPORT_NUMBER")
    public Integer getAmTechpassportNumber() {
        return amTechpassportNumber;
    }

    public void setAmTechpassportNumber(Integer amTechpassportNumber) {
        this.amTechpassportNumber = amTechpassportNumber;
    }

    @Basic
    @Column(name = "AM_BIRTHDATE")
    public Date getAmBirthdate() {
        return amBirthdate;
    }

    public void setAmBirthdate(Date amBirthdate) {
        this.amBirthdate = amBirthdate;
    }

    @Basic
    @Column(name = "AM_REGISTRATION_DATE")
    public Date getAmRegistrationDate() {
        return amRegistrationDate;
    }

    public void setAmRegistrationDate(Date amRegistrationDate) {
        this.amRegistrationDate = amRegistrationDate;
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

        CarEntity carEntity = (CarEntity) o;

        if (id != null ? !id.equals(carEntity.id) : carEntity.id != null) return false;
        if (amRegNumber != null ? !amRegNumber.equals(carEntity.amRegNumber) : carEntity.amRegNumber != null)
            return false;
        if (amColor != null ? !amColor.equals(carEntity.amColor) : carEntity.amColor != null) return false;
        if (amBodyNumber != null ? !amBodyNumber.equals(carEntity.amBodyNumber) : carEntity.amBodyNumber != null)
            return false;
        if (amEngineNumber != null ? !amEngineNumber.equals(carEntity.amEngineNumber) : carEntity.amEngineNumber != null)
            return false;
        if (amTechpassportNumber != null ? !amTechpassportNumber.equals(carEntity.amTechpassportNumber) : carEntity.amTechpassportNumber != null)
            return false;
        if (amBirthdate != null ? !amBirthdate.equals(carEntity.amBirthdate) : carEntity.amBirthdate != null)
            return false;
        if (amRegistrationDate != null ? !amRegistrationDate.equals(carEntity.amRegistrationDate) : carEntity.amRegistrationDate != null)
            return false;
        if (createdAt != null ? !createdAt.equals(carEntity.createdAt) : carEntity.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(carEntity.updatedAt) : carEntity.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amRegNumber != null ? amRegNumber.hashCode() : 0);
        result = 31 * result + (amColor != null ? amColor.hashCode() : 0);
        result = 31 * result + (amBodyNumber != null ? amBodyNumber.hashCode() : 0);
        result = 31 * result + (amEngineNumber != null ? amEngineNumber.hashCode() : 0);
        result = 31 * result + (amTechpassportNumber != null ? amTechpassportNumber.hashCode() : 0);
        result = 31 * result + (amBirthdate != null ? amBirthdate.hashCode() : 0);
        result = 31 * result + (amRegistrationDate != null ? amRegistrationDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "markId", referencedColumnName = "id")
    public MarksEntity getMarksByMarkId() {
        return marksByMarkId;
    }

    public void setMarksByMarkId(MarksEntity marksByMarkId) {
        this.marksByMarkId = marksByMarkId;
    }

    @ManyToOne
    @JoinColumn(name = "driverId", referencedColumnName = "id")
    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }

    @ManyToOne
    @JoinColumn(name = "jackedCarId", referencedColumnName = "id")
    public JackedCarsEntity getJackedCarsByJackedCarId() {
        return jackedCarsByJackedCarId;
    }

    public void setJackedCarsByJackedCarId(JackedCarsEntity jackedCarsByJackedCarId) {
        this.jackedCarsByJackedCarId = jackedCarsByJackedCarId;
    }
}
