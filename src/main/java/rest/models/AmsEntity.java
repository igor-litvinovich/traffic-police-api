package rest.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "ams")
public class AmsEntity {
    private Integer id;
    private String amRegNumber;
    private String amColor;
    private Integer amBodyNumber;
    private Integer amEngineNumber;
    private Integer amTechpassportNumber;
    private Date amBirthdate;
    private Date amRegistrationDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updatedAt")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmsEntity amsEntity = (AmsEntity) o;

        if (id != null ? !id.equals(amsEntity.id) : amsEntity.id != null) return false;
        if (amRegNumber != null ? !amRegNumber.equals(amsEntity.amRegNumber) : amsEntity.amRegNumber != null)
            return false;
        if (amColor != null ? !amColor.equals(amsEntity.amColor) : amsEntity.amColor != null) return false;
        if (amBodyNumber != null ? !amBodyNumber.equals(amsEntity.amBodyNumber) : amsEntity.amBodyNumber != null)
            return false;
        if (amEngineNumber != null ? !amEngineNumber.equals(amsEntity.amEngineNumber) : amsEntity.amEngineNumber != null)
            return false;
        if (amTechpassportNumber != null ? !amTechpassportNumber.equals(amsEntity.amTechpassportNumber) : amsEntity.amTechpassportNumber != null)
            return false;
        if (amBirthdate != null ? !amBirthdate.equals(amsEntity.amBirthdate) : amsEntity.amBirthdate != null)
            return false;
        if (amRegistrationDate != null ? !amRegistrationDate.equals(amsEntity.amRegistrationDate) : amsEntity.amRegistrationDate != null)
            return false;
        if (createdAt != null ? !createdAt.equals(amsEntity.createdAt) : amsEntity.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(amsEntity.updatedAt) : amsEntity.updatedAt != null) return false;

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
}
