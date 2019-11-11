/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.efrei.API;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francois
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeApi.findAll", query = "SELECT e FROM EmployeeApi e")
    , @NamedQuery(name = "EmployeeApi.findById", query = "SELECT e FROM EmployeeApi e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeApi.findByFirstName", query = "SELECT e FROM EmployeeApi e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "EmployeeApi.findByLastName", query = "SELECT e FROM EmployeeApi e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "EmployeeApi.findByHomePhone", query = "SELECT e FROM EmployeeApi e WHERE e.homePhone = :homePhone")
    , @NamedQuery(name = "EmployeeApi.findByCellPhone", query = "SELECT e FROM EmployeeApi e WHERE e.cellPhone = :cellPhone")
    , @NamedQuery(name = "EmployeeApi.findByWorkPhone", query = "SELECT e FROM EmployeeApi e WHERE e.workPhone = :workPhone")
    , @NamedQuery(name = "EmployeeApi.findByEMail", query = "SELECT e FROM EmployeeApi e WHERE e.eMail = :eMail")})
public class EmployeeApi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "home_phone")
    private String homePhone;
    @Size(max = 45)
    @Column(name = "cell_phone")
    private String cellPhone;
    @Size(max = 45)
    @Column(name = "work_phone")
    private String workPhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "e_mail")
    private String eMail;

    public EmployeeApi() {
    }

    public EmployeeApi(Integer id) {
        this.id = id;
    }

    public EmployeeApi(Integer id, String firstName, String lastName, String homePhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeApi)) {
            return false;
        }
        EmployeeApi other = (EmployeeApi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.efrei.API.EmployeeApi[ id=" + id + " ]";
    }
    
}
