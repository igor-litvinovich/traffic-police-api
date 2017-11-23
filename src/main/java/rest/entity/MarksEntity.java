package rest.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "marks")
public class MarksEntity {
    private String id;
    private String markName;
    private Date createdAt;
    private Date updatedAt;
    private Collection<CarEntity> amsById;
    private CountriesEntity countriesByCountryId;
    private FirmsEntity firmsByFirmId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MARK_NAME")
    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
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

        MarksEntity that = (MarksEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (markName != null ? !markName.equals(that.markName) : that.markName != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (markName != null ? markName.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "marksByMarkId")
    public Collection<CarEntity> getAmsById() {
        return amsById;
    }

    public void setAmsById(Collection<CarEntity> amsById) {
        this.amsById = amsById;
    }

    @ManyToOne
    @JoinColumn(name = "countryId", referencedColumnName = "id", nullable = true)
    public CountriesEntity getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "firmId", referencedColumnName = "id", nullable = true)
    public FirmsEntity getFirmsByFirmId() {
        return firmsByFirmId;
    }

    public void setFirmsByFirmId(FirmsEntity firmsByFirmId) {
        this.firmsByFirmId = firmsByFirmId;
    }
}
